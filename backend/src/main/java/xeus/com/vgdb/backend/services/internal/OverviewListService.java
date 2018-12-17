package xeus.com.vgdb.backend.services.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;
import xeus.com.vgdb.backend.services.IOverviewListService;

import java.util.List;

@Service
public class OverviewListService implements IOverviewListService {

    @Autowired
    private IOverviewListRepository gameSimpleListDAO;

    @Override
    public List<OverviewListElementDTO> findAllGameSimpleListElements() {
        return gameSimpleListDAO.getOverviewList();
    }
}
