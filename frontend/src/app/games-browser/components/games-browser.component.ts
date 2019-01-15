import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from '@angular/router';

import { OverviewListService } from "../services/overview-list.service";

@Component({
    selector: 'app-games-browser',
    templateUrl: './games-browser.component.html'
})
export class GamesBrowserComponent implements OnInit {

    private page: Number;
    private maxResults: Number;
    private overviewList: OverviewListItem[];

    constructor(
        private activatedRoute: ActivatedRoute,
        private overviewListService: OverviewListService
    ) {}

    ngOnInit() {
        this.loadOverviewList();
    }

    private loadOverviewList() {

        this.overviewListService.getOverviewList().subscribe(resp => {

            let response: OverviewListResponse = resp;
            this.overviewList = response.page.overviewList;
        });
    }
}
