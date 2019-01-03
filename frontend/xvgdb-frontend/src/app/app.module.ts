import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { GamesBrowserModule } from './games-browser/games-browser.module';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    GamesBrowserModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
