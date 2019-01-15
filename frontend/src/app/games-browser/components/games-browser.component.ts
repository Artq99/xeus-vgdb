import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { OverviewListService } from "../services/overview-list.service";

/**
 * The master component for the games browser.
 */
@Component({
    selector: 'app-games-browser',
    templateUrl: './games-browser.component.html'
})
export class GamesBrowserComponent implements OnInit {

    private page: number;
    private maxResults: number;
    private overviewList: OverviewListItem[];

    constructor(
        private activatedRoute: ActivatedRoute,
        private location: Location,
        private overviewListService: OverviewListService
    ) {}

    ngOnInit() {

        this.resolveUrlParams();
        this.loadOverviewList();
    }

    /**
     * The method that reads the parameters from the url, hanldes the missing ones and updates the url.
     */
    private resolveUrlParams() {

        this.activatedRoute.queryParams.subscribe(params => {
            this.page = parseInt(params['page']);
            this.maxResults = parseInt(params['maxResults']);

            if (Number.isNaN(this.page)) {
                this.page = 0;
            }

            if (Number.isNaN(this.maxResults)) {
                this.maxResults = 10;
            }

            this.updateUrl();
        });
    }

    /**
     * The method that updates the url with the parameters.
     */
    private updateUrl() {

        this.location.replaceState('games-browser?page=' + this.page + '&maxResults=' + this.maxResults);
    }

    /**
     * The method that loads the list of games from the {@link OverviewListService}.
     */
    private loadOverviewList() {

        this.overviewListService.getOverviewList(this.page, this.maxResults).subscribe(resp => {

            let response: OverviewListResponse = resp;

            console.log(response);

            if (response.status === 'ERROR') {
                // TODO The module for messages is not implemented yet.
                response.messageList.messageList.forEach(element => {
                    if (element.type === 'ERROR') {
                        console.error(element.text);
                    } else if (element.type == 'WARNING') {
                        console.warn(element.text);
                    } else {
                        console.info(element.text);
                    }
                });
                return;
            }

            this.overviewList = response.page.overviewList;
            this.page = response.page.pageNumber;
            this.maxResults = response.page.pageSize;

            if (response.status === 'SUCCESS_WITH_WARNINGS') {
                // TODO The module for messages is not implemented yet.
                response.messageList.messageList.forEach(element => {
                    if (element.type === 'WARNING') {
                        console.warn(element.text);
                    } else {
                        console.info(element.text);
                    }
                })
            }

            this.updateUrl();
        });
    }
}
