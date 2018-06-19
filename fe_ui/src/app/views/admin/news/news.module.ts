import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { NewsComponent } from './news.component';
import { NewsRoutingModule } from './news-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';
import { FroalaEditorModule, FroalaViewModule } from 'angular-froala-wysiwyg';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NewsRoutingModule,
        AppMaterialModule,
        FroalaEditorModule.forRoot(),
        FroalaViewModule.forRoot()
    ],
    declarations: [
        NewsComponent,
    ]
})

export class NewsModule { }