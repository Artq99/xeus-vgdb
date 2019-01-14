import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { CoreModule } from './core/core.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { GamesBrowserModule } from './games-browser/games-browser.module';

import { AppComponent } from './app.component';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,

        // App modules
        AppRoutingModule,
        CoreModule,
        DashboardModule,
        GamesBrowserModule
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule { }
