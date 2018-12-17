package xeus.com.vgdb.backend.persistence.internal.mapping;

import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;
import xeus.com.vgdb.backend.persistence.internal.response.OverviewListElement;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The mapper between the classes {@link OverviewListElement} and {@link OverviewListElementDTO}.
 *
 * @author Artur Matracki
 */
public class OverviewListElementMapper {

    /**
     * Maps the data from {@link OverviewListElement} to {@link OverviewListElementDTO}.
     *
     * @param element the response element
     * @return the DTO with the mapped data
     */
    public static OverviewListElementDTO createDTOFromResponse(OverviewListElement element) {
        OverviewListElementDTO dto = new OverviewListElementDTO();
        dto.setGameId(element.getGameId());
        dto.setTitle(element.getTitle());
        dto.setGameDescription(element.getGameDescription());
        dto.setReleasesCount(element.getReleasesCount());
        GregorianCalendar date = new GregorianCalendar();
        date.setTime(element.getFirstReleaseDate());
        dto.setFirstReleaseDate(date);
        return dto;
    }

    /**
     * Maps the list of {@link OverviewListElement} to the list of {@link OverviewListElementDTO}.
     *
     * @param elementList the list of response elements
     * @return the list of DTOs with the mapped data
     */
    public static List<OverviewListElementDTO> createDTOListFromResponseList(List<OverviewListElement> elementList) {
        List<OverviewListElementDTO> dtoList = new ArrayList<>();
        for (OverviewListElement element : elementList) {
            dtoList.add(createDTOFromResponse(element));
        }
        return dtoList;
    }
}
