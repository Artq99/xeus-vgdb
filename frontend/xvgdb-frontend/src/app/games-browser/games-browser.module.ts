import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OverviewListComponent } from './components/overview-list/overview-list.component';
import { OverviewListService } from './services/overview-list.service';

/**
 * Module that holds the functionality related to browsing the games.
 */
@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    OverviewListComponent
  ],
  providers: [
    OverviewListService
  ],
  exports: [
    OverviewListComponent
  ]
})
export class GamesBrowserModule { }
