import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { RatioComponent } from './ratio.component';
import { RatioRoutingModule } from './ratio-routing.module';
import { AppMaterialModule } from '../../../app-material/app-material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RatioRoutingModule,
    AppMaterialModule
  ],
  declarations: [RatioComponent]
})
export class RatioModule { }