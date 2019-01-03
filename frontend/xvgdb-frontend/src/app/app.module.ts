import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OverviewListComponent } from './overview-list/overview-list.component';
import { OverviewListService } from './overview-list.service';

@NgModule({
  declarations: [
    AppComponent,
    OverviewListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    OverviewListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
