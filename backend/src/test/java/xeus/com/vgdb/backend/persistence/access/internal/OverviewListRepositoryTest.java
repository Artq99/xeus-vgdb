package xeus.com.vgdb.backend.persistence.access.internal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xeus.com.vgdb.backend.Application;

/**
 * The test class with persistence tests for the class {@link OverviewListRepository}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OverviewListRepositoryTest {

    @Autowired
    private OverviewListRepository repositoryUnderTest;

    @Test
    public void shouldReturnOverviewListItemCount() {

        // when
        long count = repositoryUnderTest.getOverviewListCount();

        // then
        Assert.assertEquals(1, count);
    }

}
