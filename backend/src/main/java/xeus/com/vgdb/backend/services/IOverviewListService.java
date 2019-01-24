package xeus.com.vgdb.backend.services;

import xeus.com.vgdb.backend.services.response.OverviewListPageResponse;

/**
 * The service for accessing the list of games in an overview form.
 *
 * @author Artur Matracki
 */
public interface IOverviewListService {

    /**
     * Method that returns a single page from a paginated overview list of games.
     *
     * @param pageNumber page number of the list
     * @param pageSize   number of results on one page
     * @return page from the list
     */
    OverviewListPageResponse getOverviewList(int pageNumber, final int pageSize);
}
