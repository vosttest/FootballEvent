import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';

@Component({
    selector: 'app-news',
    templateUrl: './news.component.html',
    styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

    public content: string = '';

    constructor(
        public dialog: MatDialog
    ) { }

    ngOnInit() {
    }

    public viewNews() {
        this.dialog.open(DialogNews, {
            data: {
                title: "",
                content: "<strong>hihihaha</strong>"
            }
        });
    }
}

@Component({
    selector: 'app-news',
    templateUrl: 'dialog.component.html',
    styleUrls: ['./news.css']
})
export class DialogNews {

    constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

}