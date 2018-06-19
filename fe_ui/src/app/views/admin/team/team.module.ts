import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { TeamComponent } from './team.component';
import { TeamRoutingModule } from './team-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';
import { FroalaEditorModule, FroalaViewModule } from 'angular-froala-wysiwyg';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        TeamRoutingModule,
        AppMaterialModule,
        FroalaEditorModule.forRoot(),
        FroalaViewModule.forRoot()
    ],
    declarations: [
        TeamComponent,
    ]
})

export class TeamModule { }