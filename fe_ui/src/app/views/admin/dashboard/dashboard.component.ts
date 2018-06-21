import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

    calendar = [
        { id: '1', tournament: 'WC2018', date: '15/06/2018', team1: 'Germany', logo1: '../assets/img/flag/Germany.png', team2: 'Mexico', logo2: '../assets/img/flag/Mexico.png', goal1: '0', goal2: '1' },
        { id: '2', tournament: 'WC2018', date: '16/06/2018', team1: 'Brazil', logo1: '../assets/img/flag/Brazil.png', team2: 'Spain', logo2: '../assets/img/flag/Spain.png', goal1: '1', goal2: '0' },
        { id: '3', tournament: 'EURO2020', date: '16/06/2020', team1: 'France', logo1: '../assets/img/flag/France.png', team2: 'Portugal', logo2: '../assets/img/flag/Portugal.png', goal1: '0', goal2: '2' },
        { id: '4', tournament: 'EURO2020', date: '15/06/2020', team1: 'Poland', logo1: '../assets/img/flag/Poland.png', team2: 'Iceland', logo2: '../assets/img/flag/Iceland.png', goal1: '1', goal2: '2' },
    ];
    rsall = [
        { id: '1', category: 'Win-Lose', name: 'DuyNhat', phone: '123456798', date: '15/06/2018', calendar: 'Germany-Brazil', result: '1 : 0', amount: '1234' },
        { id: '2', category: 'Over-Under', name: 'DuyNhat', phone: '123456798', date: '17/06/2018', calendar: 'Germany-Brazil', result: 'Over', amount: '1234' },
        { id: '3', category: 'Champion', name: 'DuyNhat', phone: '123456798', date: '16/06/2018', calendar: '', result: 'Vietnam', amount: '1234' },
        { id: '4', category: 'Top4', name: 'DuyNhat', phone: '123456798', date: '18/06/2018', calendar: '', result: 'Vietnam,Lao,Campuchia,Singapore', amount: '1234' },
        { id: '5', category: 'Score', name: 'DuyNhat', phone: '123456798', date: '18/06/2018', calendar: 'Germany-Brazil', result: '3 : 0', amount: '1234' },
    ];
    sortedData;
    sortedDatarsall;

    constructor(private rou: Router,
        private act: ActivatedRoute) { }

    ngOnInit() {
        this.sortedData = this.calendar.slice();
        this.sortedDatarsall = this.rsall.slice();
    }

    sortData(sort: Sort) {
        const data = this.calendar.slice();
        if (!sort.active || sort.direction == '') {
            this.sortedData = data;
            return;
        }
        this.sortedData = data.sort((a, b) => {
            let isAsc = sort.direction == 'asc';
            switch (sort.active) {
                case 'tournament': return compare(a.tournament, b.tournament, isAsc);
                case 'date': return compare(a.date, b.date, isAsc);
                default: return 0;
            }
        });
    }
    sortDatarsall(sort: Sort) {
        const data = this.rsall.slice();
        if (!sort.active || sort.direction == '') {
            this.sortedDatarsall = data;
            return;
        }
        this.sortedDatarsall = data.sort((a, b) => {
            let isAsc = sort.direction == 'asc';
            switch (sort.active) {
                case 'category': return compare(a.category, b.category, isAsc);
                case 'date': return compare(a.date, b.date, isAsc);
                default: return 0;
            }
        });
    }
    public redirect(url: string) {
        this.rou.navigate(["admin/" + url]);
    }
}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}