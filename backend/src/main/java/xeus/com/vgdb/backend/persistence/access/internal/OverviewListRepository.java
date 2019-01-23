package xeus.com.vgdb.backend.persistence.access.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xeus.com.vgdb.backend.persistence.access.IOverviewListRepository;
import xeus.com.vgdb.backend.persistence.access.internal.mapping.OverviewListMapper;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem;
import xeus.com.vgdb.backend.persistence.dto.OverviewListItemDTO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OverviewListRepository implements IOverviewListRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OverviewListItemDTO> getOverviewList(final int firstResult, final int maxResults) {

        Query query = entityManager.createNamedQuery("GetOverviewList", OverviewListResponseItem.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);

        @SuppressWarnings("unchecked")
        List<OverviewListResponseItem> resultList = query.getResultList();

        return OverviewListMapper.createDTOListFromResponseList(resultList);
    }

    @Override
    public long getOverviewListCount() {

        Query query = entityManager.createNamedQuery("GetOverviewListCount", Long.class);
        Long count = (Long) query.getSingleResult();

        return count;
    }

}
