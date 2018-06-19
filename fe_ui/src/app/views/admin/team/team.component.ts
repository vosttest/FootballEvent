import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Sort, MatPaginator } from '@angular/material';

@Component({
    selector: 'app-team',
    templateUrl: './team.component.html',
    styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
    public data2 = "";
    public function = "overview";

    public continent = [
        { value: 'c1', viewValue: 'Asia' },
        { value: 'c2', viewValue: 'Europe' },
        { value: 'c3', viewValue: 'America' },
        { value: 'c4', viewValue: 'Africa' },
        { value: 'c5', viewValue: 'Oceania' },
    ];
    public country = [
        { value: 'a1', viewValue: 'Russia' },
        { value: 'a2', viewValue: 'Spain' },
        { value: 'a3', viewValue: 'Brazil' },
        { value: 'a4', viewValue: 'Korea' },
        { value: 'a5', viewValue: 'VietNam' },
    ];
    public data = [
        { name: 'Brazil', logo: 'Brazil.png', coach: 'Tite', country: 'Brazil', continent: 'America' },
        { name: 'Germany', logo: 'Germany.png', coach: 'Loew Joachim', country: 'Germany', continent: 'Europe' },
        { name: 'Australia', logo: 'Australia.png', coach: 'Van Marwijk Bert', country: 'Australia', continent: 'Oceania' },
        { name: 'Nigeria', logo: 'Nigeria.png', coach: 'Rohr Gernot', country: 'Nigeria', continent: 'Africa' },
        { name: 'Japan', logo: 'Japan.png', coach: 'Nishino Akira', country: 'Japan', continent: 'Asia' }
    ];
    public toppingList = ['World Cup', 'Euro ', 'AFC Cup', 'Copa America'];
    public sortedData: any;

    toppings = new FormControl();

    @ViewChild(MatPaginator) paginator: MatPaginator;

    constructor(private rou: Router,
        private act: ActivatedRoute) { }

    ngOnInit() {
        this.act.params.subscribe((params: Params) => {
            document.getElementById(this.function).style.display = "none";
            this.function = params["function"];
            document.getElementById(this.function).style.display = "block";
        });

        this.sortedData = this.data.slice();
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

}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}