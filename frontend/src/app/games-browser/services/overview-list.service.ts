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
     * The method that returns the overview list of games.
     */
    getOverviewList(): Observable<OverviewListResponse> {
        let params: HttpParams = new HttpParams().set('page', '0').set('maxResults', '10');
        return this.httpClient.get<OverviewListResponse>(this.overviewListGetUrl, { params: params });
    }

}
