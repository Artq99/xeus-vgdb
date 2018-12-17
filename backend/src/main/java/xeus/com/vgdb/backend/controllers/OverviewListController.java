package xeus.com.vgdb.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;
import xeus.com.vgdb.backend.services.IOverviewListService;

import java.util.List;

/**
 * The controller for getting the list of games in an overview form.
 *
 * @author Artur Matracki
 */
@RestController
@RequestMapping("/overviewList")
public class OverviewListController {

    @Autowired
    private IOverviewListService gameSimpleListService;

    @GetMapping("/get")
    public List<OverviewListElementDTO> findAllGameSimpleListElements() {
        return gameSimpleListService.findAllGameSimpleListElements();
    }
}
