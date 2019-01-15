import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OverviewListService } from './services/overview-list.service';

import { GamesBrowserComponent } from './components/games-browser.component';
import { OverviewListComponent } from './components/overview-list/overview-list.component';
import { PaginationControlComponent } from './components/pagination-control/pagination-control.component';

/**
 * Module that holds the functionality related to browsing the games.
 */
@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        GamesBrowserComponent,
        OverviewListComponent,
        PaginationControlComponent
    ],
    providers: [
        OverviewListService
    ],
    exports: [
        GamesBrowserComponent
    ]
})
export class GamesBrowserModule { }
