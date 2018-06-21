import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { TeamComponent } from './team.component';
import { TeamRoutingModule } from './team-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';
import { NgxEditorModule } from 'ngx-editor';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        TeamRoutingModule,
        AppMaterialModule,
        NgxEditorModule
    ],
    declarations: [
        TeamComponent,
    ]
})

export class TeamModule { }