import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/components/dashboard.component';
import { GamesBrowserComponent } from './games-browser/components/games-browser.component';

const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'games-browser', component: GamesBrowserComponent },
    { path: 'games-browser?page=:page&maxResults=:maxResults', component: GamesBrowserComponent }
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
