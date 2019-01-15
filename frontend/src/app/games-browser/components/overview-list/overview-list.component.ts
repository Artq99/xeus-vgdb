import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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

    overviewList: OverviewListItem[];

    constructor(private route: ActivatedRoute, private overviewListService: OverviewListService) {
        this.route.queryParams.subscribe( params => console.log(params));
    }

    ngOnInit() {
        this.overviewListService.getOverviewList().subscribe(res => {
            let response: OverviewListResponse = res;
            this.overviewList = response.page.overviewList;
        });
    }

}
