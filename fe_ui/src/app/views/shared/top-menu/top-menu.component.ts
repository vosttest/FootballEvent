import { Component, OnInit, ViewChild } from '@angular/core';
import { UserProvider } from '../../../providers/provider';
import { HTTP } from '../../../utilities/utility';
import { ModalDirective } from 'ngx-bootstrap';

@Component({
    selector: 'app-top-menu',
    templateUrl: './top-menu.component.html',
    styleUrls: ['./top-menu.component.css']
})

export class TopMenuComponent implements OnInit {
    public isNavbarCollapsed = true;
    public loader = false;
    public isShow = false;

    public vm: any = { userName: "", amount: "" };

    @ViewChild("confirmModal") public confirmModal: ModalDirective;

    constructor(private pro: UserProvider) { }

    ngOnInit() {
        this.view();
    }

    private view() {
        this.loader = true;

        this.pro.view().subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.vm = rsp.result;
                this.isShow = true;
            } else {
                console.log(rsp.message);
            }

            this.loader = false;
        }, err => console.log(err));
    }

    public showConfirm() {
        this.confirmModal.show();
    }

    public signOut() {
        this.pro.signOut();
        this.confirmModal.hide();
        window.location.reload();
    }
}