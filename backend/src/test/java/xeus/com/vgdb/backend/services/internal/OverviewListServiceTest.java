package xeus.com.vgdb.backend.services.internal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;
import xeus.com.vgdb.backend.services.response.OverviewListPageResponse;
import xeus.com.vgdb.backend.services.response.ResponseStatus;
import xeus.com.vgdb.backend.services.response.messages.Message;
import xeus.com.vgdb.backend.services.response.messages.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * The test class for {@link OverviewListService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class OverviewListServiceTest {

    @Mock
    private IOverviewListRepository overviewListRepository;

    @InjectMocks
    private OverviewListService serviceUnderTest;

    @Test
    public void getOverviewList_shouldReturnSinglePageOfOverviewList() {

        // given
        OverviewListItemDTO testItem = new OverviewListItemDTO();
        List<OverviewListItemDTO> testItemList = new ArrayList<>();
        testItemList.add(testItem);

        Mockito.when(overviewListRepository.getOverviewList(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(testItemList);
        Mockito.when(overviewListRepository.getOverviewListCount()).thenReturn(1L);

        // when
        OverviewListPageResponse response = serviceUnderTest.getOverviewList(0, 10);

        // then
        Assert.assertNotNull(response);
        Assert.assertEquals(testItemList, response.getPage().getOverviewList());
        Assert.assertEquals(0, response.getPage().getPageNumber());
        Assert.assertEquals(10, response.getPage().getPageSize());
        Assert.assertEquals(1, response.getPage().getTotalItemsCount());
        Assert.assertEquals(1, response.getPage().getTotalPagesCount());
        Assert.assertEquals(ResponseStatus.SUCCESS, response.getStatus());
        Assert.assertEquals(0, response.getMessageList().size());
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewList(0, 10);
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewListCount();
        Mockito.verifyNoMoreInteractions(overviewListRepository);
    }

    @Test
    public void getOverviewList_shouldReturnErrorMessage_whenPageSizeIsZero() {

        // given when
        OverviewListPageResponse response = serviceUnderTest.getOverviewList(0, 0);

        // then
        Assert.assertNotNull(response);
        Assert.assertNull(response.getPage());
        Assert.assertEquals(1, response.getMessageList().size());
        Message message = response.getMessageList().get(0);
        Assert.assertEquals(MessageType.ERROR, message.getType());
        Assert.assertEquals("Page size cannot be less than one.", message.getText());
        Mockito.verifyZeroInteractions(overviewListRepository);
    }

    @Test
    public void getOverviewList_shouldReturnErrorMessage_whenPageSizeIsLessThanZero() {

        // given when
        OverviewListPageResponse response = serviceUnderTest.getOverviewList(0, -10);

        // then
        Assert.assertNotNull(response);
        Assert.assertNull(response.getPage());
        Assert.assertEquals(ResponseStatus.ERROR, response.getStatus());
        Assert.assertEquals(1, response.getMessageList().size());
        Message message = response.getMessageList().get(0);
        Assert.assertEquals(MessageType.ERROR, message.getType());
        Assert.assertEquals("Page size cannot be less than one.", message.getText());
        Mockito.verifyZeroInteractions(overviewListRepository);
    }

    @Test
    public void getOverviewList_shouldReturnWarningAndCorrectPageNumber_whenPageNumberIsLessThanZero() {

        // given
        OverviewListItemDTO testItem = new OverviewListItemDTO();
        List<OverviewListItemDTO> testItemList = new ArrayList<>();
        testItemList.add(testItem);

        Mockito.when(overviewListRepository.getOverviewList(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(testItemList);
        Mockito.when(overviewListRepository.getOverviewListCount()).thenReturn(1L);

        // when
        OverviewListPageResponse response = serviceUnderTest.getOverviewList(-1, 10);

        // then
        Assert.assertNotNull(response);
        Assert.assertEquals(testItemList, response.getPage().getOverviewList());
        Assert.assertEquals(0, response.getPage().getPageNumber());
        Assert.assertEquals(10, response.getPage().getPageSize());
        Assert.assertEquals(1, response.getPage().getTotalItemsCount());
        Assert.assertEquals(1, response.getPage().getTotalPagesCount());
        Assert.assertEquals(ResponseStatus.SUCCESS_WITH_WARNINGS, response.getStatus());
        Assert.assertEquals(1, response.getMessageList().size());
        Message message = response.getMessageList().get(0);
        Assert.assertEquals(MessageType.WARNING, message.getType());
        Assert.assertEquals("Page number cannot be less than zero.", message.getText());
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewList(0, 10);
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewListCount();
        Mockito.verifyNoMoreInteractions(overviewListRepository);
    }

    @Test
    public void getOverviewList_shouldReturnWarningAndCorrectPageNumber_whenPageNumberIsTooBig() {

        // given
        OverviewListItemDTO testItem = new OverviewListItemDTO();
        List<OverviewListItemDTO> testItemList = new ArrayList<>();
        testItemList.add(testItem);

        Mockito.when(overviewListRepository.getOverviewList(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(testItemList);
        Mockito.when(overviewListRepository.getOverviewListCount()).thenReturn(1L);

        // when
        OverviewListPageResponse response = serviceUnderTest.getOverviewList(1, 10);

        // then
        Assert.assertNotNull(response);
        Assert.assertEquals(testItemList, response.getPage().getOverviewList());
        Assert.assertEquals(0, response.getPage().getPageNumber());
        Assert.assertEquals(10, response.getPage().getPageSize());
        Assert.assertEquals(1, response.getPage().getTotalItemsCount());
        Assert.assertEquals(1, response.getPage().getTotalPagesCount());
        Assert.assertEquals(ResponseStatus.SUCCESS_WITH_WARNINGS, response.getStatus());
        Assert.assertEquals(1, response.getMessageList().size());
        Message message = response.getMessageList().get(0);
        Assert.assertEquals(MessageType.WARNING, message.getType());
        Assert.assertEquals("Page number cannot be greater than the last page number.", message.getText());
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewList(0, 10);
        Mockito.verify(overviewListRepository, Mockito.times(1)).getOverviewListCount();
        Mockito.verifyNoMoreInteractions(overviewListRepository);
    }

}
