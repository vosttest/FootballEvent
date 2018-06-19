import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'app-calendar',
    templateUrl: './calendar.component.html',
    styleUrls: ['./calendar.component.css']
})

export class CalendarComponent implements OnInit {
    states = [
        'WC 2018', 'EURO 2020'
    ];
    calendar = [
        { id: '1', tournament: 'WC2018', date: '15/06/2018', team1: 'Germany', logo1: '../assets/img/flag/Germany.png', team2: 'Mexico', logo2: '../assets/img/flag/Mexico.png', goal1: '0', goal2: '1' },
        { id: '2', tournament: 'WC2018', date: '16/06/2018', team1: 'Brazil', logo1: '../assets/img/flag/Brazil.png', team2: 'Spain', logo2: '../assets/img/flag/Spain.png', goal1: '1', goal2: '0' },
        { id: '3', tournament: 'EURO2020', date: '16/06/2020', team1: 'France', logo1: '../assets/img/flag/France.png', team2: 'Portugal', logo2: '../assets/img/flag/Portugal.png', goal1: '0', goal2: '2' },
        { id: '4', tournament: 'EURO2020', date: '15/06/2020', team1: 'Poland', logo1: '../assets/img/flag/Poland.png', team2: 'Iceland', logo2: '../assets/img/flag/Iceland.png', goal1: '1', goal2: '2' },
    ];
    sortedCalendar;
    public function = "overview";

    constructor(private rou: Router,
        private act: ActivatedRoute) { }

    ngOnInit() {
        this.act.params.subscribe((params: Params) => {
            document.getElementById(this.function).style.display = "none";
            this.function = params["function"];
            document.getElementById(this.function).style.display = "block";
        });

        this.sortedCalendar = this.calendar.slice();
    }

    sortCalendar(sort: Sort) {
        const data = this.calendar.slice();
        if (!sort.active || sort.direction == '') {
            this.sortedCalendar = data;
            return;
        }
        this.sortedCalendar = data.sort((a, b) => {
            let isAsc = sort.direction == 'asc';
            switch (sort.active) {
                case 'tournament': return compare(a.tournament, b.tournament, isAsc);
                case 'date': return compare(a.date, b.date, isAsc);
                default: return 0;
            }
        });
    }

    public redirect(url: string) {
        this.rou.navigate(["admin/calendar/" + url]);
    }
}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}