import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { NewsComponent } from './news.component';
import { NewsRoutingModule } from './news-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';
import { NgxEditorModule } from 'ngx-editor';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NewsRoutingModule,
        AppMaterialModule,
        NgxEditorModule
    ],
    declarations: [
        NewsComponent,
    ]
})

export class NewsModule { }