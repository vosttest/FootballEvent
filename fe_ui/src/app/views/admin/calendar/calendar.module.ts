import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CalendarComponent } from './calendar.component';
import { CalendarRoutingModule } from './calendar-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        CalendarRoutingModule,
        AppMaterialModule
    ],
    declarations: [
        CalendarComponent,
    ]
})

export class CalendarModule { }