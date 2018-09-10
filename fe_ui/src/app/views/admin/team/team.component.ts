import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Sort, MatPaginator } from '@angular/material';

import { TeamProvider, CommonProvider } from '../../../providers/provider';
import { HTTP } from '../../../utilities/utility';

@Component({
    selector: 'app-team',
    templateUrl: './team.component.html',
    styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
    public data: any = [];
    public lstTour: any = [];
    public continent = ['Asia', 'Europe', 'America', 'Africa', 'Oceania'];
    public country = [
        { value: 'a1', viewValue: 'Russia' },
        { value: 'a2', viewValue: 'Spain' },
        { value: 'a3', viewValue: 'Brazil' },
        { value: 'a4', viewValue: 'Korea' },
        { value: 'a5', viewValue: 'VietNam' },
    ];
    public sortedData: any;

    public function = "overview";
    public vm: any = { content: "", tournament: "", icon: "Vietnam.png" };
    public loader = false;

    toppings = new FormControl();

    editorConfig = {
        editable: true,
        spellcheck: false,
        height: '10rem',
        minHeight: '5rem',
        placeholder: 'Please type someting!',
        translate: 'no'
    };

    @ViewChild(MatPaginator) paginator: MatPaginator;

    constructor(private pro: TeamProvider,
        private proCommon: CommonProvider,
        private rou: Router,
        private act: ActivatedRoute) { }

    ngOnInit() {
        this.act.params.subscribe((params: Params) => {
            document.getElementById(this.function).style.display = "none";
            this.function = params["function"];
            document.getElementById(this.function).style.display = "block";
        });

        this.search();
        this.getType('Statement');
    }

    private search() {
        this.loader = true;

        this.pro.search("").subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.data = rsp.result.data;
                this.sortedData = this.data.slice();
            }
            else {
                console.log(rsp.message);
            }

            this.loader = false;
        }, err => console.log(err));
    }

    private getType(type: string) {
        this.proCommon.search(type).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                if (type == "Statement") {
                    this.lstTour = rsp.result.data;
                    console.log(this.lstTour);

                }
            }
        }, err => console.log(err));
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
                case 'name': return compare(a.name, b.name, isAsc);
                case 'coach': return compare(a.coach, b.coach, isAsc);
                case 'country': return compare(a.country, b.country, isAsc);
                case 'continent': return compare(a.continent, b.continent, isAsc);
                default: return 0;
            }
        });
    }

    public redirect(url: string) {
        this.rou.navigate(["admin/team/" + url]);
    }

    files: FileList;
    getFiles(event) {
        this.files = event.target.files;
        this.vm.icon = this.files[0].name;
    }

}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}