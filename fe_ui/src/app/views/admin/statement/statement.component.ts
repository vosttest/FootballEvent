import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'app-statement',
    templateUrl: './statement.component.html',
    styleUrls: ['./statement.component.css']
})
export class StatementComponent implements OnInit {
    states = [
        'WC 2018', 'EURO 2020'
    ];
    desserts = [
        { id: '1', team: 'Germany', logo: '../assets/img/flag/Germany.png', group: 'A' },
        { id: '2', team: 'France', logo: '../assets/img/flag/France.png', group: 'B' },
        { id: '3', team: 'Brazil', logo: '../assets/img/flag/Brazil.png', group: 'C' },
        { id: '4', team: 'Russia', logo: '../assets/img/flag/Russia.png', group: 'D' },
        { id: '5', team: 'Spanish', logo: '../assets/img/flag/Spain.png', group: 'E' },
    ];
    groups = [
        'None Group', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'
    ];
    lstteam = [
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
        { name: 'Germany', logo: '../assets/img/flag/Germany.png' },
    ];

    public function = "overview";
    panelOpenState: boolean = true;
    sortedData;
    count = 0; // Số lượng team trong group
    disCheck = true;
    grttt = "None Group";

    constructor(private rou: Router,
        private act: ActivatedRoute) {
    }

    ngOnInit() {
        this.act.params.subscribe((params: Params) => {
            document.getElementById(this.function).style.display = "none";
            this.function = params["function"];
            document.getElementById(this.function).style.display = "block";
        });

        this.sortedData = this.desserts.slice();
    }

    sortData(sort: Sort) {
        const data = this.desserts.slice();
        if (!sort.active || sort.direction == '') {
            this.sortedData = data;
            return;
        }
        this.sortedData = data.sort((a, b) => {
            let isAsc = sort.direction == 'asc';
            switch (sort.active) {
                case 'id': return compare(a.id, b.id, isAsc);
                case 'team': return compare(a.team, b.team, isAsc);
                default: return 0;
            }
        });
    }

    clickcheck(e: any) {
        if (e === true) {
            this.count++;
        } else (this.count--);
        if (this.grttt === "None Group") {
            this.disCheck = false;
        }
        else {
            if (this.count === 4) {
                this.disCheck = false;
            }
            else {
                this.disCheck = true;
            }
        }
    }

    public redirect(url: string) {
        this.rou.navigate(["admin/statement/" + url]);
    }
}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}