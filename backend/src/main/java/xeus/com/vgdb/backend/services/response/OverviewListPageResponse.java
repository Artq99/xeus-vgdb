package xeus.com.vgdb.backend.services.response;

import xeus.com.vgdb.backend.persistence.dto.OverviewListPageDTO;

/**
 * The web response class for the paginated overview list of games.
 *
 * @author Artur Matracki
 */
public class OverviewListPageResponse extends AbstractWebResponse {

    private OverviewListPageDTO page;

    public OverviewListPageDTO getPage() {
        return page;
    }

    public void setPage(OverviewListPageDTO page) {
        this.page = page;
    }
}
