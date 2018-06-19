import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-layout-admin',
    templateUrl: './layout-admin.component.html',
    styleUrls: ['./layout-admin.component.css']
})

export class LayoutAdminComponent implements OnInit {
    public cssNav: any;

    constructor(public rou: Router) { }

    ngOnInit() {
        this.cssNav = document.getElementsByClassName("nav-item");
        for (var i = 0; i < this.cssNav.length; i++) {
            this.cssNav[i].removeAttribute("tabindex");
        }
    }

    public active(str: string) {
        for (var i = 0; i < this.cssNav.length; i++) {
            this.cssNav[i].style.backgroundColor = "#eef5f9";
        }

        document.getElementById(str).style.backgroundColor = "#26c6da";
    }
}