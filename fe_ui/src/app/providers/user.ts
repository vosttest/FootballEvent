import 'rxjs/add/operator/toPromise';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ApiProvider } from './api';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class UserProvider {
    public timerLogout;
    public subscriptionLogout;

    constructor(private api: ApiProvider,
        private rou: Router) { }

    /**
     * Sign in
     * @param info
     */
    public signIn(info: any) {
        //info.password = this.rsa.encrypt(info.password); // encrypt password
        return this.api.post("user/sign-in", info);
    }

    /**
     * Sign up
     * @param info
     */
    public signUp(info: any) {
        //info.password = this.rsa.encrypt(info.password); // encrypt password
        return this.api.post("user/sign-up", info);
    }

    /**
     * Sign in by Phone Number
     * @param info
     */
    public verifyPhone(info: any) {
        return this.api.post("user/verify-phone", info);
    }

    /**
     * Sign out
     */
    public signOut() {
        this.api.get("user/sign-out").subscribe((rsp: any) => {
        }, err => console.log(err));
        localStorage.removeItem("CURRENT_TOKEN");
        this.rou.navigate(["/guess"]);
    }

    /**
     * View user
     */
    public view() {
        return this.api.get('user/view');
    }

    /**
     * Save authentication
     * @param token
     * @param redirect
     */
    public saveAuth(token: string, redirect: boolean = true) {
        let t = this.api.saveToken(token);
        this.timerLogout = Observable.interval(this.api.milliseconds);

        this.subscriptionLogout = this.timerLogout.subscribe(x => {
            let now = new Date();
            if (now > this.api.nextRun && this.api.allowLogout) {
                this.signOut();
            }
        });

        if (redirect) {
            this.rou.navigate(["/guess"]);
            //this.checkRedirect(t.user.accessrights);
        }
    }

    /**
     * Check access rights
     * @param right
     */
    public checkAccessRights(right: String): boolean {
        let res: any = JSON.parse(localStorage.getItem("CURRENT_TOKEN"));
        if (res == null) {
            return false;
        }

        if (right === "/dashboard") {
            right = "Dashboard";
        }

        let ok = res.accessRights.find(x => x === right);
        return ok != undefined && ok != "";
    }

    /**
     * Check redirection
     */
    public checkRedirection() {
        let user = JSON.parse(localStorage.getItem("CURRENT_TOKEN"));
        if (user != null) {
            this.checkRedirect(user.accessRights);
        }
    }

    /**
     * Check redirect
     * @param ar Access rights
     */
    private checkRedirect(ar: any) {
        let dashboard = ar.find(myObj => myObj == "Dashboard");
        let report = ar.find(myObj => myObj == "Report");

        if (dashboard != undefined) {
            this.rou.navigate(["/dashboard"]);
        }
        else {
            this.rou.navigate(["/error-page"]);
        }
    }
}