package xeus.com.vgdb.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xeus.com.vgdb.backend.services.IOverviewListService;
import xeus.com.vgdb.backend.services.response.OverviewListPageResponse;

/**
 * The controller for accessing the list of games in an overview form.
 *
 * @author Artur Matracki
 */
@RestController
@RequestMapping("/overviewList")
public class OverviewListController {

    @Autowired
    private IOverviewListService overviewListService;

    /**
     * Request that returns a page from a paginated overview list of games.
     *
     * @param page page number of the list
     * @param maxResults number of results on one page
     * @return page from the list
     */
    @CrossOrigin
    @GetMapping("/get")
    public OverviewListPageResponse getPaginatedOverviewList(
            @RequestParam final int page,
            @RequestParam final int maxResults) {

        return overviewListService.getOverviewList(page, maxResults);
    }
}
