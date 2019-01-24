package xeus.com.vgdb.backend.persistence.access.internal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import xeus.com.vgdb.backend.Application;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * The test class with persistence tests for {@link OverviewListRepository}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OverviewListRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private OverviewListRepository repositoryUnderTest;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialise() {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void getOverviewListCount_shouldReturnNumberOfGames() {

        // given
        long expectedCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "t_game");

        // when
        long count = repositoryUnderTest.getOverviewListCount();

        // then
        Assert.assertEquals(expectedCount, count);
    }

}
