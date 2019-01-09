package xeus.com.vgdb.backend.persistence.dto;

import java.util.List;

/**
 * The data transfer object for a single page of the paginated overview list of the games.
 *
 * @author Artur Matracki
 */
public class OverviewListPageDTO {

    private List<OverviewListItemDTO> overviewList;
    private int pageNumber;
    private int pageSize;
    private int totalItemsCount;
    private int totalPagesCount;

    public List<OverviewListItemDTO> getOverviewList() {
        return overviewList;
    }

    public void setOverviewList(List<OverviewListItemDTO> overviewList) {
        this.overviewList = overviewList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

    public int getTotalPagesCount() {
        return totalPagesCount;
    }

    public void setTotalPagesCount(int totalPagesCount) {
        this.totalPagesCount = totalPagesCount;
    }
}
