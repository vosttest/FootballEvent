import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppMaterialModule } from './app-material/app-material.module';
import { MnFullpageModule } from 'ngx-fullpage';
import { ModalModule, CarouselModule } from 'ngx-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { ApiProvider, UserProvider, TeamProvider, CommonProvider,CalendarProvider, RatioProvider, BetProvider } from './providers/provider';

import { AppComponent } from './app.component';
import { GuessComponent} from './views/guess/guess.component';
import { CalendarComponent, DialogMatch } from './views/calendar/calendar.component';
import { TopMenuComponent } from './views/shared/top-menu/top-menu.component';
import { NewsComponent, DialogNews } from './views/news/news.component';
import { EqualValidator } from "./utilities/utility";
import { LayoutAdminComponent } from './views/layouts/layout-admin/layout-admin.component';
import { BottomMenuComponent } from './views/shared/bottom-menu/bottom-menu.component';

@NgModule({
    declarations: [
        AppComponent,
        GuessComponent,
        CalendarComponent,
        DialogMatch,
        TopMenuComponent,
        NewsComponent,
        DialogNews,
        EqualValidator,
        LayoutAdminComponent,
        BottomMenuComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        FormsModule,
        AppMaterialModule,
        MnFullpageModule.forRoot(),
        ModalModule.forRoot(),
        CarouselModule.forRoot(),
        HttpClientModule,
        NgbModule.forRoot(),
    ],
    entryComponents: [CalendarComponent, DialogMatch, DialogNews],
    providers: [
        ApiProvider,
        UserProvider,
        TeamProvider,
        CommonProvider,
        CalendarProvider,
        RatioProvider,
        BetProvider
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }