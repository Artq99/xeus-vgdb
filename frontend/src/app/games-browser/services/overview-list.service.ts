import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { environment } from '../../../environments/environment';

/**
 * Service for obtaining the overview list of games from the backend.
 */
@Injectable()
export class OverviewListService {

    private overviewListGetUrl = environment.backendUrl + '/overviewList/get';

    constructor(private httpClient: HttpClient) { }

    /**
     * The method that returns one page from the overview list of games.
     */
    getOverviewList(page: number, maxResults: number): Observable<OverviewListResponse> {
        let params: HttpParams = new HttpParams().set('page', String(page)).set('maxResults', String(maxResults));
        return this.httpClient.get<OverviewListResponse>(this.overviewListGetUrl, { params: params });
    }

}
