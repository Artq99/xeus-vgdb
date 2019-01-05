package xeus.com.vgdb.backend.persistence.internal.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.dto.OverviewListElementDTO;
import xeus.com.vgdb.backend.persistence.internal.constants.NamedQueriesConstants;
import xeus.com.vgdb.backend.persistence.internal.mapping.OverviewListElementMapper;
import xeus.com.vgdb.backend.persistence.internal.response.OverviewListElement;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OverviewListRepository implements IOverviewListRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OverviewListElementDTO> getOverviewList() {
        List<OverviewListElement> responseList = entityManager
                .createNamedQuery(
                        NamedQueriesConstants.QUERY_NAME_GET_OVERVIEW_LIST,
                        OverviewListElement.class)
                .getResultList();
        return OverviewListElementMapper.createDTOListFromResponseList(responseList);
    }
}
