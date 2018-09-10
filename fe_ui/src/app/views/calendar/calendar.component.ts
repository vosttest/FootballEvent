import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatTabChangeEvent } from '@angular/material';
import { CalendarProvider } from '../../providers/provider';
import { HTTP, Regex } from '../../utilities/utility';

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
    styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

    public vm: any;
    public vm1: any;

    public fromDate = new Date();
    public toDate1 = new Date();
    public date = new Date();
    public date2 = new Date();
    public toDate2;
    public toDate3;
    public calendar: any[] = [];

    public imgURL = "../../../../assets/img/flag_wc/";

    constructor(
        public dialog: MatDialog,
        private cal: CalendarProvider,
    ) { }

    ngOnInit() {
        // let b= new Date(this.date.getHours())
        // console.log(this.date.getHours());
        // console.log(this.date2);
        // let a = new Date(this.date2.setHours(this.date2.getHours() -24));
        // console.log(a);
        this.loadData();
    }

    public openDialog() {
        this.dialog.open(DialogMatch, {
            data: {
                animal: 'panda'
            }
        });
    }

    ngAfterViewChecked() {

    }

    public loadData() {
        this.toDate2 = this.date.setDate(this.date.getDate() + 5);
        let a = new Date(this.toDate2);
        let obj = {
            fromDate: this.fromDate,
            toDate: a
        }
        this.cal.search(obj).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.vm = rsp.result;
                this.calendar = this.vm;
                this.date = new Date();
                // console.log(this.vm[0].calendarDetail[0].competitionDate1);
                // console.log(new Date(this.vm[0].calendarDetail[0].competitionDate1).getHours()-5);
            } else {
                console.log(rsp)
            }
        }, err => console.log(err));
    }

    public loadData2() {
        let obj = {
            fromDate: '2018-06-14',
            toDate: this.toDate1
        }
        this.cal.search(obj).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.vm = rsp.result;
                this.calendar = this.vm;
            } else {
                console.log(rsp)
            }
        }, err => console.log(err));
    }

    public loadTab(event: MatTabChangeEvent) {
        if (event.index == 0) {
            this.loadData();
        }
        else if (event.index == 1) {
            this.loadData2();
        }
        else
            this.loadData2();
    }
}

@Component({
    selector: 'app-calendar',
    templateUrl: 'dialog.component.html',
})
export class DialogMatch {

    constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

}