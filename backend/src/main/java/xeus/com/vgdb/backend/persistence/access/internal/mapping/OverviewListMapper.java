package xeus.com.vgdb.backend.persistence.access.internal.mapping;

import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The mapper between the classes {@link OverviewListResponseItem} and {@link OverviewListItemDTO}.
 *
 * @author Artur Matracki
 */
public class OverviewListMapper {

    /**
     * Maps the data from {@link OverviewListResponseItem} to {@link OverviewListItemDTO}.
     *
     * @param item the response item
     * @return the DTO with the mapped data
     */
    public static OverviewListItemDTO createDTOFromResponse(OverviewListResponseItem item) {

        OverviewListItemDTO dto = new OverviewListItemDTO();
        dto.setGameId(item.getGameId());
        dto.setTitle(item.getTitle());
        dto.setGameDescription(item.getGameDescription());
        dto.setReleasesCount(item.getReleasesCount());

        Date firstReleaseDate = item.getFirstReleaseDate();
        if (firstReleaseDate != null) {
            GregorianCalendar firstReleaseDateGC = new GregorianCalendar();
            firstReleaseDateGC.setTime(item.getFirstReleaseDate());
            dto.setFirstReleaseDate(firstReleaseDateGC);
        }

        return dto;
    }

    /**
     * Maps the list of {@link OverviewListResponseItem} to the list of {@link OverviewListItemDTO}.
     *
     * @param itemList the list of response items
     * @return the list of DTOs with the mapped data
     */
    public static List<OverviewListItemDTO> createDTOListFromResponseList(List<OverviewListResponseItem> itemList) {

        List<OverviewListItemDTO> dtoList = new ArrayList<>();
        for (OverviewListResponseItem item : itemList) {
            dtoList.add(createDTOFromResponse(item));
        }

        return dtoList;
    }

}
