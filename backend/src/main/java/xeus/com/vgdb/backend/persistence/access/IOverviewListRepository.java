package xeus.com.vgdb.backend.persistence.access;

import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;

import java.util.List;

/**
 * The repository for accessing data from the query <code>GetOverviewList</code>.
 *
 * @author Artur Matracki
 */
public interface IOverviewListRepository {

    /**
     * Returns the list of the {@link OverviewListElementDTO} with all games in the database.
     *
     * @return list of all games
     */
    List<OverviewListElementDTO> getOverviewList();
}
