import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardComponent } from './components/dashboard.component';

/**
 * Module that holds the functionality of the dashboard - the start page.
 */
@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [
        DashboardComponent
    ],
    exports: [
        DashboardComponent
    ]
})
export class DashboardModule { }
