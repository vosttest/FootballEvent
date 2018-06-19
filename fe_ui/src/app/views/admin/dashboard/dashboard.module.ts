import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DashboardComponent } from './dashboard.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        DashboardRoutingModule,
        AppMaterialModule
    ],
    declarations: [
        DashboardComponent,
    ]
})

export class DashboardModule { }