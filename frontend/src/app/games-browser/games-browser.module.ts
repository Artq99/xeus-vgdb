import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OverviewListService } from './services/overview-list.service';

import { GamesBrowserComponent } from './components/games-browser.component';
import { OverviewListComponent } from './components/overview-list/overview-list.component';

/**
 * Module that holds the functionality related to browsing the games.
 */
@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        GamesBrowserComponent,
        OverviewListComponent
    ],
    providers: [
        OverviewListService
    ],
    exports: [
        GamesBrowserComponent
    ]
})
export class GamesBrowserModule { }
