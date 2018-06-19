import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Sort } from '@angular/material';

@Component({
    selector: 'app-news',
    templateUrl: './news.component.html',
    styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
    public data2 = "";
    public function = "overview";

    public data = [
        { tilte: 'Kane lập cú đúp, Anh thắng trận ra quân', content: 'Pha làm bàn ở phút bù giờ hiệp hai của tiền đạo đội trưởng giúp tuyển Anh đánh bại Tunisia với tỷ số 2-1 ở World Cup 2018, tối 18/6.' },
        { tilte: 'Lukaku lập cú đúp, Bỉ đại thắng Panama', content: 'Sự toả sáng của các cá nhân trong hiệp hai giúp Bỉ đánh bại tân binh của World Cup 2018 với tỷ số 3-0 ở trận ra quân tối 18/6.' }
    ];
    public sortedData: any;

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
                case 'tilte': return compare(a.tilte, b.tilte, isAsc);
                case 'content': return compare(a.content, b.content, isAsc);
                default: return 0;
            }
        });
    }

    public redirect(url: string) {
        this.rou.navigate(["admin/news/" + url]);
    }
}

function compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}