import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RatioProvider } from '../../../providers/provider';
import { HTTP } from '../../../utilities/utility';

@Component({
    selector: 'app-ratio',
    templateUrl: './ratio.component.html',
    styleUrls: ['./ratio.component.css']
})

export class RatioComponent implements OnInit {
    public function = "overview";

    public data = [
        { time: '2018-06-14 22:00', team1: 'Russia', team2: 'Saudi Arabia', ratio: '1.2', bigsmall: '2.3', aa: '3.3' }
    ];
    public dataRatio: any = [];
    public dataRatio2: any = [];

    public vm: any = {
        id: "5",
        calendarId: "3",
        code: "code",
        r11: 1.2,
        r12: 2,
        r13: 2.6,
        r21: 3,
        r22: 3.5,
        r31: 2.15,
        r32: 3.14,
        r33: 2.1,
        r4: 2,
    };

    public sortedData: any;

    constructor(private rou: Router,
        private act: ActivatedRoute,
        private proRatio: RatioProvider) { }

    ngOnInit() {
        this.act.params.subscribe((params: Params) => {
            document.getElementById(this.function).style.display = "none";
            this.function = params["function"];
            document.getElementById(this.function).style.display = "block";
        });
        this.sortedData = this.data.slice();
        this.search();
        this.getById(2);
        this.save();
    }

    sortData(sort: Sort) {
        const data = this.data.slice();
        if (!sort.active || sort.direction == '') {
            this.sortedData = data;
            return;
        }
        this.sortedData = data.sort((a, b) => {
            let isAsc = sort.direction == 'asc';
            switch (sort.active) {
                case 'time': return compare(a.time, b.time, isAsc);
                case 'team1': return compare(a.team1, b.team1, isAsc);
                case 'team2': return compare(a.team2, b.team2, isAsc);
                case 'ratio': return compare(a.ratio, b.ratio, isAsc);
                case 'bigsmall': return compare(a.bigsmall, b.bigsmall, isAsc);
                case 'aa': return compare(a.aa, b.aa, isAsc);
                default: return 0;
            }
        });
    }

    public redirect(url: string) {
        this.rou.navigate(["admin/ratio/" + url]);
    }

    private search() {
        this.proRatio.search().subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.dataRatio = rsp.result.data;
                console.log(this.dataRatio);
            }
            else {
                console.log(rsp.message);
            }
        }, err => console.log(err));
    }

    public getById(id: any) {
        this.proRatio.getById(id).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.dataRatio = rsp.result;
                console.log(this.dataRatio);
            }
            else {
                console.log(rsp.message);
            }
        }, err => console.log(err));
    }

    public save() {
        this.proRatio.save(this.vm).subscribe((rsp: any) => {
        }, err => console.log(err))
    }
}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
