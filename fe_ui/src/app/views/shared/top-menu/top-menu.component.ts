import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ModalDirective } from 'ngx-bootstrap';
import { UserProvider } from '../../../providers/provider';
import { HTTP } from '../../../utilities/utility';

@Component({
    selector: 'app-top-menu',
    templateUrl: './top-menu.component.html',
    styleUrls: ['./top-menu.component.css']
})

export class TopMenuComponent implements OnInit {
    public pwdPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$$";

    @ViewChild("signInModal") public signInModal: ModalDirective;
    @ViewChild("signUpModal") public signUpModal: ModalDirective;

    public vmSI: any = {};
    public vmSU: any = {};

    constructor(
        private pro: UserProvider,
        private rou: Router
    ) { }

    ngOnInit() { }

    public signIn() {
        this.pro.signIn(this.vmSI).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                console.log(rsp);
            } else {
                console.log(rsp)
            }
        }, err => console.log(err));
    }

    public signUp() {
        this.pro.signUp(this.vmSU).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                console.log(rsp);
            } else {
                console.log(rsp)
            }
        }, err => console.log(err));
    }
}