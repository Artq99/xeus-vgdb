import { Component, OnInit } from '@angular/core';
import { OverviewListService } from '../../services/overview-list.service';

/**
 * Component rendering the overview list of the games.
 */
@Component({
    selector: 'app-overview-list',
    templateUrl: './overview-list.component.html',
    styleUrls: ['./overview-list.component.css']
})
export class OverviewListComponent implements OnInit {

    overviewList: OverviewListElement[];

    constructor(private overviewListService: OverviewListService) { }

    ngOnInit() {
        this.overviewListService.getOverviewList().subscribe(list => this.overviewList = list);
    }

}
