import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { ModalDirective } from 'ngx-bootstrap';
import { ApiProvider, BetProvider, CalendarProvider, RatioProvider, TeamProvider, UserProvider } from '../../providers/provider';
import { HTTP, Regex } from '../../utilities/utility';
import { MatTabChangeEvent } from '@angular/material';

@Component({
    selector: 'app-guess',
    templateUrl: './guess.component.html',
    styleUrls: ['./guess.component.css',],
})

export class GuessComponent implements OnInit {
    public pwdPattern = Regex.PASSWORD_DIFFICULTY;
    public phonePattern = Regex.PHONE_NUMBER;

    public calendar: any[] = [];
    public lstTeam: any = [];
    public vmTeam: any = [];

    public ratioTHT: any = {};
    public ratioTS: any = {};
    public ratioTX: any = {};
    public vmSI: any = {};
    public vmBet: any = { calendarId: 1, code: "THT", g11: null, g21: null, g22: null, g31: null, g41: null, amount: null, subQuestion: null, status: "" };
    public vm: any;
    public vmchampion: any = { championId: "", subQuestion: null, phoneOne: null ,top4Id:""};
    public vmTop4: any = { championId: "", subQuestion: null, phoneOne: null ,top4Id:""};

    public imgURL = "../../../../assets/img/flag_wc/";

    public loader: boolean = false;
    public success = false;
    public isDisabled = true;
    public show = false;

    public fromDate = new Date();
    public toDate1 = new Date();
    public toDate2;
    public timeGuess;

    public selected = "";
    public token = "";
    public msg = "";
    public label: string = "";
    public rsResult = ""; //KQ checkbox thắng-hòa-thua
    public tsResult;
    public sRatioRS = 1;
    public rsOU = ""; //KQ checkbox tài-xỉu
    public tsOU;
    public sRatioOU = 1;
    public rsScore = ""; //KQ checkbox Score
    public tsScore;
    public sRatioScore = 10;
    public code = "THT";
    public subQuesRS = "";
    public subQuesScore = "";
    public subQuesOU = "";
    public isShowr11 = false;
    public isShowr12 = false;
    public isShowr13 = false;
    public isShowr31 = false;
    public isShowr32 = false;

    @ViewChild("guessModal") public guessModal: ModalDirective;
    @ViewChild("signInModal") public signInModal: ModalDirective;
    @ViewChild("accessTokenModal") public accessTokenModal: ModalDirective;
    @ViewChild("informationModal") public informationModal: ModalDirective;
    @ViewChild("notificationModal") public notificationModal: ModalDirective;

    constructor(private proApi: ApiProvider,
        private pro: UserProvider,
        private cal: CalendarProvider,
        private proRatio: RatioProvider,
        private proBet: BetProvider,
        private proTeam: TeamProvider,
        private rou: Router, ) { }

    ngOnInit() {
        this.loadData();
        this.searchTeam();
    }

    ngAfterContentChecked() {
        let outCircle = document.getElementsByClassName("mat-radio-outer-circle") as HTMLCollectionOf<HTMLElement>;
        let innerCircle = document.getElementsByClassName("mat-radio-inner-circle") as HTMLCollectionOf<HTMLElement>;
        for (var i = 0; i < outCircle.length; i++) {
            outCircle[i].style.borderColor = "gray";
            innerCircle[i].style.backgroundColor = "pink";
        }
    }

    public loadData() {
        this.toDate2 = this.toDate1.setDate(this.toDate1.getDate() + 5);
        let a = new Date(this.toDate2);
        let obj = {
            fromDate: this.fromDate,
            toDate: a
        }
        this.cal.search(obj).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.vm = rsp.result;
                this.calendar = this.vm;
                this.toDate1 = new Date();
            } else {
                console.log(rsp);
            }
        }, err => console.log(err));
    }

    private searchRatiobyCal(id: any) {
        this.proRatio.getByCal(id).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                for (var i = 0; i < rsp.result.length; i++) {
                    if (rsp.result[i].code === "THT") {
                        this.ratioTHT = rsp.result[i];
                    }
                    else if (rsp.result[i].code === "TS") {
                        this.ratioTS = rsp.result[i];
                    }
                    else this.ratioTX = rsp.result[i];
                }
            }
            else {
                console.log(rsp.message);
            }
        }, err => console.log(err));
    }

    private searchTeam() {
        this.loader = true;

        this.proTeam.search("").subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.lstTeam = rsp.result.data;
            }
            else {
                console.log(rsp.message);
            }

            this.loader = false;
        }, err => console.log(err));
    }

    private getTeamByCal(id: any) {
        this.proTeam.getByCal(id).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.vmTeam = rsp.result;
            }
            else {
                console.log(rsp.message);
            }
            this.loader = false;
        }, err => console.log(err));
    }

    public showModal(id: any, time: any) {
        let a = new Date(time);
        a.setHours(a.getHours() - 72);

        if (this.toDate1 > a && this.toDate1 < time) {
            this.searchRatiobyCal(10);
            this.guessModal.show();
            this.getTeamByCal(id);

            this.vmBet.calendarId = id;
        } else {
            this.timeGuess = a;
            this.notificationModal.show();
        }
    }

    public changeResult(value: any) {
        if (value === "11") {
            this.rsResult = this.vmTeam.name1 + " Win";
            this.sRatioRS = this.ratioTHT.r11;
            this.isShowr11 = true;
            this.vmBet.g11 = "0";
        } else if (value === "12") {
            this.rsResult = this.vmTeam.name1 + " Draw " + this.vmTeam.name2;
            this.sRatioRS = this.ratioTHT.r12;
            this.isShowr12 = true;
            this.vmBet.g11 = "1";
        } else {
            this.rsResult = this.vmTeam.name2 + " Win";
            this.sRatioRS = this.ratioTHT.r13;
            this.isShowr13 = true;
            this.vmBet.g11 = "2";
        }
    }

    public changeOU(value: any) {
        if (value === "31") {
            this.rsOU = "Under";
            this.sRatioOU = this.ratioTX.r33;
            this.vmBet.g31 = "1";
            this.isShowr31 = true;
        } else {
            this.rsOU = "Over";
            this.sRatioOU = this.ratioTX.r32;
            this.vmBet.g31 = "2";
            this.isShowr32 = true;
        }
    }

    public guess() {
        let t = this.proApi.getToken();

        if (this.code == "THT") {
            this.vmBet.subQuestion = this.subQuesRS;
        }
        else if (this.code == "TS") {
            this.vmBet.subQuestion = this.subQuesScore;
        }
        else if (this.code == "TX") {
            // Code for Over/Under tab
            this.vmBet.subQuestion = this.subQuesOU;
        }

        if (t != "") {
            this.proBet.save(this.vmBet).subscribe((rsp: any) => {
                if (rsp.status === HTTP.STATUS_SUCCESS) {
                    this.vmBet.g11 = null;
                    this.vmBet.g21 = null;
                    this.vmBet.g22 = null;
                    this.vmBet.g31 = null;
                    this.vmBet.g41 = null;

                    this.msg = "Save successfully!";
                    this.guessModal.hide();
                } else {
                    this.msg = rsp.message;
                }

                this.informationModal.show();

                this.loader = false;
            }, err => console.log(err));
        }
        else {
            this.guessModal.hide();
            this.signInModal.show();
        } err => console.log(err);
    }

    public hideModal() {
        this.rsResult = "";
        this.sRatioRS = 1;
        this.tsResult = "";
        this.rsOU = "";
        this.sRatioOU = 1;
        this.tsOU = "";
        this.vmBet.subQuestion = "";
        this.subQuesRS = "";
        this.subQuesScore = "";
        this.subQuesOU = "";
        this.isShowr11 = false;
        this.isShowr12 = false;
        this.isShowr13 = false;
        this.isShowr31 = false;
        this.isShowr32 = false;
        this.guessModal.hide();
    }

    public signIn() {
        this.loader = true;

        let obj = {
            userName: this.vmSI.userName,
            clientKey: this.vmSI.clientKey,
            token: this.vmSI.token,
            sendToken: true
        };

        this.pro.verifyPhone(obj).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.msg = "";

                if (!rsp.result.authen) {
                    this.pro.saveAuth(rsp.result.key); // save JWT
                } else {
                    this.vmSI.clientKey = rsp.result.key; // client key

                    this.vmSI.codeNumber1 = null;
                    this.vmSI.codeNumber2 = null;
                    this.vmSI.codeNumber3 = null;
                    this.vmSI.codeNumber4 = null;
                    this.vmSI.codeNumber5 = null;
                    this.vmSI.codeNumber6 = null;

                    this.isDisabled = true;
                    this.show = true;

                    this.accessTokenModal.show();
                    setTimeout(function () {
                        document.getElementById("codeNumber1").focus();
                    }, 500);
                }
            } else {
                this.msg = rsp.message;
            }

            this.loader = false;
        }, err => console.log(err));
    }

    public cancelAccessTokenModal() {
        $("#codeNumber1").val(null);
        $("#codeNumber2").val(null);
        $("#codeNumber3").val(null);
        $("#codeNumber4").val(null);
        $("#codeNumber5").val(null);
        $("#codeNumber6").val(null);
        this.accessTokenModal.hide();
    }

    public proceedClick() {
        this.loader = true;

        if (this.token.length < 6) {
            return;
        }

        let obj = {
            userName: this.vmSI.userName,
            clientKey: this.vmSI.clientKey,
            token: this.token,
            sendToken: false
        };

        this.pro.verifyPhone(obj).subscribe((rsp: any) => {

            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.pro.saveAuth(rsp.result.key);
                this.success = true;

                this.proBet.save(this.vmBet).subscribe((rsp: any) => {
                    if (rsp.status === HTTP.STATUS_SUCCESS) {
                        this.success = true;
                        window.location.reload();
                    } else {
                        this.msg = rsp.message;
                        this.success = false;
                    }

                    this.loader = false;
                }, err => console.log(err));

                this.accessTokenModal.hide();
                this.signInModal.hide();
                this.guessModal.hide();
            } else {
                this.msg = "Token is not match";
                // this.msg = rsp.message;
            }

            this.loader = false;
        }, err => { console.log(err); this.loader = false; });
    }

    public checkMaxlength(inputNumber: string, $event) {
        this.isDisabled = true;
        let element = $event.target.nextElementSibling;
        let value = $event.target.value;
        let key = $event.key;

        switch (inputNumber) {
            case "input1":
                if (value.length > 1) {
                    $("#codeNumber1").val(key);
                }
                this.vmSI.codeNumber1 = key;
                break;

            case "input2":
                if (value.length > 1) {
                    $("#codeNumber2").val(key);
                }
                this.vmSI.codeNumber2 = key.toString();
                break;

            case "input3":
                if (value.length > 1) {
                    $("#codeNumber3").val(key);
                }
                this.vmSI.codeNumber3 = key.toString();
                break;

            case "input4":
                if (value.length > 1) {
                    $("#codeNumber4").val(key);
                }
                this.vmSI.codeNumber4 = key.toString();
                break;

            case "input5":
                if (value.length > 1) {
                    $("#codeNumber5").val(key);
                }
                this.vmSI.codeNumber5 = key.toString();
                break;

            case "input6":
                if (value.length > 1) {
                    $("#codeNumber6").val(key);
                }
                this.vmSI.codeNumber6 = key.toString();
                break;
        }

        this.token = this.vmSI.codeNumber1 + this.vmSI.codeNumber2
            + this.vmSI.codeNumber3 + this.vmSI.codeNumber4
            + this.vmSI.codeNumber5 + this.vmSI.codeNumber6;

        if (this.token.length == 6) {
            this.isDisabled = false;
        }

        // Check focus next input
        if (element == null || $event.key == "Backspace") {
            return;
        }
        else {
            element.focus();
        }
    }

    public selectTab(event: MatTabChangeEvent) {
        let index = event.index;

        if (index == 0) {
            // Code for Result tab
            this.code = "THT";
        }
        else if (index == 1) {
            // Code for Score tab
            this.code = "TS";
        }
        else if (index == 2) {
            // Code for Over/Under tab
            this.code = "TX";
        }

        this.vmBet.code = this.code;
        // console.log('event => ', event);
    }
    public ok() {
        this.rou.navigate(['/guess']);
        this.informationModal.hide();
        this.guessModal.hide();
    }

    public saveGuess() {
        let obj;
        let obj1 = {
            championId: this.vmchampion.championId,
            phoneNo:this.vmchampion.phoneNo,
            subQuestion:this.vmchampion.subQuestion,
            top4Id: ""
        };

        let obj2 = {
            championId: "",
            phoneNo: this.vmTop4.phoneNo,
            subQuestion: this.vmTop4.subQuestion,
            top4Id: this.vmTop4.top4Id
        };

        if (this.vmchampion.championId != "") {
            obj = obj1;
        }
        if (this.vmTop4.top4Id != "") {
            obj = obj2
        }

        this.proBet.saveguess(obj).subscribe((rsp: any) => {
            if (rsp.status === HTTP.STATUS_SUCCESS) {
                this.informationModal.show();
            }
            else {
                console.log(rsp.message);
            }
            this.loader = false;
        }, err => console.log(err));
    }
}