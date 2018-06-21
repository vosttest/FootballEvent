import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { CalendarComponent } from './views/calendar/calendar.component';
import { GuessComponent } from './views/guess/guess.component';
import { NewsComponent } from './views/news/news.component';

import { LayoutAdminComponent } from './views/layouts/layout-admin/layout-admin.component';

const routes: Routes = [
    { path: '', redirectTo: 'guess', pathMatch: 'full' },
    { path: 'calendar', component: CalendarComponent },
    { path: 'guess', component: GuessComponent },
    { path: 'news', component: NewsComponent },
    {
        path: 'admin',
        component: LayoutAdminComponent,
        children:
            [
                {
                    path: 'dashboard/:function',
                    loadChildren: './views/admin/dashboard/dashboard.module#DashboardModule'
                }, {
                    path: 'calendar/:function',
                    loadChildren: './views/admin/calendar/calendar.module#CalendarModule'
                }, {
                    path: 'statement/:function',
                    loadChildren: './views/admin/statement/statement.module#StatementModule'
                }, {
                    path: 'team/:function',
                    loadChildren: './views/admin/team/team.module#TeamModule'
                }, {
                    path: 'news/:function',
                    loadChildren: './views/admin/news/news.module#NewsModule'
                }
            ]
    },
    { path: '**', redirectTo: 'guess', pathMatch: 'full' }
];

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forRoot(routes, { useHash: true })
    ],
    exports: [RouterModule],
    declarations: []
})

export class AppRoutingModule { }