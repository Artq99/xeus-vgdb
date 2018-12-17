package xeus.com.vgdb.backend.services;

import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;

import java.util.List;

/**
 * The service for getting the list of games in an overview form.
 *
 * @author Artur Matracki
 */
public interface IOverviewListService {

    /**
     * Returns the list of games in an overview form.
     *
     * @return the list of games
     */
    List<OverviewListElementDTO> findAllGameSimpleListElements();
}
