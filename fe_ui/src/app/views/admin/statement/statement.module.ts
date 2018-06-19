import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { StatementComponent } from './statement.component';
import { StatementRoutingModule } from './statement-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        StatementRoutingModule,
        AppMaterialModule
    ],
    declarations: [
        StatementComponent,
    ]
})

export class StatementModule { }