import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { ApiProvider, UserProvider, CalendarProvider } from '../../providers/provider';
import { HTTP, Regex } from '../../utilities/utility';
import { ModalDirective } from 'ngx-bootstrap';

@Component({
    selector: 'app-guess',
    templateUrl: './guess.component.html',
    styleUrls: ['./guess.component.css',],
})

export class GuessComponent implements OnInit {
    public pwdPattern = Regex.PASSWORD_DIFFICULTY;
    public phonePattern = Regex.PHONE_NUMBER;

    public vmSI: any = {};
    public vmSU: any = {};
     public date= new Date();

    public vm: any;

    @ViewChild("signInModal") public signInModal: ModalDirective;
    @ViewChild("signUpModal") public signUpModal: ModalDirective;

    constructor(public dialog: MatDialog,
        private proApi: ApiProvider,
        private pro: UserProvider,
        private cal: CalendarProvider) { }

    ngOnInit() { this.search()
    console.log(this.date);
     }

    public signIn() {
        this.pro.signIn(this.vmSI).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.pro.saveAuth(rsp.result, false);

                this.signInModal.hide();

                this.dialog.open(DialogGuess, {
                    data: {
                        animal: 'panda'
                    }
                });
            } else {
                console.log(rsp);
            }
        }, err => console.log(err));
    }

    public signUp() {
        this.pro.signUp(this.vmSU).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.pro.saveAuth(rsp.result, false);
            } else {
                console.log(rsp)
            }
        }, err => console.log(err));
    }

    public openDialog() {
        let t = this.proApi.getToken();
        if (t != "") {
            this.dialog.open(DialogGuess, {
                data: {
                    animal: 'panda'
                }
            });
        }
        else {
            this.signInModal.show();

        } err => console.log(err);
    }

    ngAfterContentChecked() {
        let outCircle = document.getElementsByClassName("mat-radio-outer-circle") as HTMLCollectionOf<HTMLElement>;
        let innerCircle = document.getElementsByClassName("mat-radio-inner-circle") as HTMLCollectionOf<HTMLElement>;
        for (var i = 0; i < outCircle.length; i++) {
            outCircle[i].style.borderColor = "gray";
            innerCircle[i].style.backgroundColor = "pink";
        }
    }

    public search() {
        this.cal.search().subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                console.log(rsp.status);

                this.vm = rsp.result;
                console.log(this.vm[1].id);
            } else {
                console.log(rsp);
            }
        }, err => console.log(err));
    }
}



@Component({
    selector: 'app-guess',
    templateUrl: 'dialog.component.html',
})

export class DialogGuess {
    constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

}