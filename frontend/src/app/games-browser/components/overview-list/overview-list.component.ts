import { Component, OnInit, Input } from '@angular/core';

/**
 * Component rendering the overview list of the games.
 */
@Component({
    selector: 'app-overview-list',
    templateUrl: './overview-list.component.html'
})
export class OverviewListComponent {

    @Input() list: OverviewListItem[];
}
