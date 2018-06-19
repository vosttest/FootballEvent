import { Component, OnInit, OnDestroy } from '@angular/core';
import * as $ from 'jquery';

@Component({
    selector: 'app-guess',
    templateUrl: './guess.component.html',
    styleUrls: ['./guess.component.css']
})
export class GuessComponent implements OnInit {

     mnFullpageService: any;
    constructor() { }
    

    ngOnInit() {
    }

    ngAfterContentChecked() {
        let outCircle = document.getElementsByClassName("mat-radio-outer-circle") as HTMLCollectionOf<HTMLElement>;
        let innerCircle = document.getElementsByClassName("mat-radio-inner-circle") as HTMLCollectionOf<HTMLElement>;
        for (var i = 0; i < outCircle.length; i++) {
            outCircle[i].style.borderColor = "white";
            innerCircle[i].style.backgroundColor = "white";
        }
    }
}
