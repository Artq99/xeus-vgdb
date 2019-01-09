package xeus.com.vgdb.backend.persistence.access.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;
import xeus.com.vgdb.backend.persistence.access.internal.mapping.OverviewListMapper;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListCountResponse;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem;
import xeus.com.vgdb.backend.persistence.internal.NamedQueriesConstants;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OverviewListRepository implements IOverviewListRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OverviewListItemDTO> getOverviewList(final int firstResult, final int maxResults) {

        TypedQuery query = entityManager
                .createNamedQuery(
                        NamedQueriesConstants.QUERY_NAME_GET_OVERVIEW_LIST,
                        OverviewListResponseItem.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);

        @SuppressWarnings("unchecked")
        List<OverviewListResponseItem> resultList = query.getResultList();

        return OverviewListMapper.createDTOListFromResponseList(resultList);
    }

    @Override
    public int getOverviewListCount() {

        return entityManager
                .createNamedQuery(
                        NamedQueriesConstants.QUERY_NAME_GET_OVERVIEW_LIST_COUNT,
                        OverviewListCountResponse.class)
                .getSingleResult()
                .getCount();
    }
}
