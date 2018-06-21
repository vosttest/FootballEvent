import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
    styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

    public vm: any;
    constructor(
        public dialog: MatDialog
    ) { }

    ngOnInit() {
    }

    public openDialog() {
        this.dialog.open(DialogMatch, {
            data: {
                animal: 'panda'
            }
        });
    }

}

@Component({
    selector: 'app-calendar',
    templateUrl: 'dialog.component.html',
})
export class DialogMatch {

    constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

}