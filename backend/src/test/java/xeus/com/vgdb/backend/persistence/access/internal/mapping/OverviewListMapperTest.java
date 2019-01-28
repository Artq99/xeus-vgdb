package xeus.com.vgdb.backend.persistence.access.internal.mapping;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem;
import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;

import java.util.*;

/**
 * The test class for {@link OverviewListMapper}.
 *
 * @author Artur Matracki
 */
public class OverviewListMapperTest {

    @Test
    public void createDTOFromResponse_shouldReturnDTOWithMappedData() {

        // given
        Long gameId = 1L;
        String title = "title";
        String gameDescription = "description";
        Long releasesCount = 3L;
        Date firstReleaseDate = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
        OverviewListResponseItem testResponseItem = new OverviewListResponseItem(gameId, title, gameDescription,
                releasesCount, firstReleaseDate);

        // when
        OverviewListItemDTO dto = OverviewListMapper.createDTOFromResponse(testResponseItem);

        // then
        Assert.assertNotNull(dto);
        Assert.assertEquals(gameId, dto.getGameId());
        Assert.assertEquals(title, dto.getTitle());
        Assert.assertEquals(gameDescription, dto.getGameDescription());
        Assert.assertEquals(releasesCount, dto.getReleasesCount());
        Assert.assertEquals(firstReleaseDate.getTime(), dto.getFirstReleaseDate().getTimeInMillis());
    }

    @Test
    public void createDTOFromResponse_shouldNotThrowException_whenFirstReleaseDateIsNull() {

        // given
        Long gameId = 1L;
        String title = "title";
        String gameDescription = "description";
        Long releasesCount = 3L;
        Date firstReleaseDate = null;
        OverviewListResponseItem testResponseItem = new OverviewListResponseItem(gameId, title, gameDescription,
                releasesCount, firstReleaseDate);

        // when
        OverviewListItemDTO dto = OverviewListMapper.createDTOFromResponse(testResponseItem);

        // then
        Assert.assertNotNull(dto);
    }

    @Test
    public void createDTOListFromResponseList_shouldReturnDTOListWithMappedData() {

        // given
        OverviewListResponseItem testResponseItem1 = new OverviewListResponseItem(1L, null, null, null, null);
        OverviewListResponseItem testResponseItem2 = new OverviewListResponseItem(2L, null, null, null, null);
        OverviewListResponseItem testResponseItem3 = new OverviewListResponseItem(3L, null, null, null, null);
        List<OverviewListResponseItem> testResponseList = new ArrayList<>();
        testResponseList.add(testResponseItem1);
        testResponseList.add(testResponseItem2);
        testResponseList.add(testResponseItem3);

        // when
        List<OverviewListItemDTO> dtoList = OverviewListMapper.createDTOListFromResponseList(testResponseList);

        // then
        Assert.assertThat(dtoList, Matchers.hasSize(3));
        Assert.assertEquals(Long.valueOf(1), dtoList.get(0).getGameId());
        Assert.assertEquals(Long.valueOf(2), dtoList.get(1).getGameId());
        Assert.assertEquals(Long.valueOf(3), dtoList.get(2).getGameId());
    }

}
