import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RatioComponent } from './ratio.component';

const routes: Routes = [
    {
        path: '',
        component: RatioComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class RatioRoutingModule { }