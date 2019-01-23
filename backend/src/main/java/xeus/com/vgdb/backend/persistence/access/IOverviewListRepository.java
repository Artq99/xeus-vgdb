package xeus.com.vgdb.backend.persistence.access;

import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;

import java.util.List;

/**
 * The repository for accessing the list of games in an overview form.
 *
 * @author Artur Matracki
 */
public interface IOverviewListRepository {

    /**
     * Method that returns an overview list of games with specified index of the first result and the maximal number
     * of results.
     *
     * @param firstResult index of the first result item
     * @param maxResults  maximal number of results
     * @return list of games
     */
    List<OverviewListItemDTO> getOverviewList(final int firstResult, final int maxResults);

    /**
     * Method that returns the total number of games in the database.
     *
     * @return number of games
     */
    long getOverviewListCount();
}
