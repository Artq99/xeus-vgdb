import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/components/dashboard.component';
import { OverviewListComponent } from './games-browser/components/overview-list/overview-list.component';

const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'games-browser', component: OverviewListComponent },
    { path: 'games-browser?page=:page&maxResults=:maxResults', component: OverviewListComponent }
]

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
