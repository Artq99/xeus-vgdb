package xeus.com.vgdb.backend.services.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;
import xeus.com.vgdb.backend.persistence.dto.OverviewListPageDTO;
import xeus.com.vgdb.backend.services.IOverviewListService;
import xeus.com.vgdb.backend.services.response.OverviewListPageResponse;
import xeus.com.vgdb.backend.services.response.messages.Message;
import xeus.com.vgdb.backend.services.response.messages.MessageList;

import java.util.List;

@Service
public class OverviewListService implements IOverviewListService {

    private static final String ERROR_PAGE_SIZE_LESS_THAN_ONE = "Page size cannot be less than one.";
    private static final String WARNING_PAGE_NUMBER_LESS_THAN_ZERO = "Page number cannot be less than zero.";
    private static final String WARNING_PAGE_NUMBER_GREATER_THAN_MAX = "Page number cannot be greater than the last " +
            "page number.";

    @Autowired
    private IOverviewListRepository overviewListRepository;

    @Override
    public OverviewListPageResponse getOverviewList(int pageNumber, final int pageSize) {

        OverviewListPageResponse response = new OverviewListPageResponse();
        MessageList messageList = response.getMessageList();

        if (pageSize <= 0) {
            messageList.add(Message.createError(ERROR_PAGE_SIZE_LESS_THAN_ONE));
            return response;
        }

        if (pageNumber < 0) {
            pageNumber = 0;
            messageList.add(Message.createWarning(WARNING_PAGE_NUMBER_LESS_THAN_ZERO));
        }

        int totalItemsCount = Math.toIntExact(overviewListRepository.getOverviewListCount());
        final int totalPagesCount = calculateTotalPagesCount(totalItemsCount, pageSize);

        if (pageNumber > totalPagesCount - 1) {
            pageNumber = totalPagesCount - 1;
            messageList.add(Message.createWarning(WARNING_PAGE_NUMBER_GREATER_THAN_MAX));
        }

        final int firstResult = pageNumber * pageSize;
        List<OverviewListItemDTO> overviewList = overviewListRepository.getOverviewList(firstResult, pageSize);

        OverviewListPageDTO page = new OverviewListPageDTO();
        page.setOverviewList(overviewList);
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setTotalItemsCount(totalItemsCount);
        page.setTotalPagesCount(totalPagesCount);

        response.setPage(page);
        return response;
    }

    private int calculateTotalPagesCount(final int totalItemsCount, final int pageSize) {

        return (int) Math.ceil((double) totalItemsCount / pageSize);
    }
}
