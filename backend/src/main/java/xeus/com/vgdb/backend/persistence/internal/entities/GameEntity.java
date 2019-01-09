package xeus.com.vgdb.backend.persistence.internal.entities;

import xeus.com.vgdb.backend.persistence.internal.NamedQueriesConstants;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListCountResponse;
import xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The entity representing the table <code>t_game</code> from the database.
 *
 * @author Artur Matracki
 */
@Entity
@Table(name = "t_game")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = NamedQueriesConstants.QUERY_NAME_GET_OVERVIEW_LIST,
                query = NamedQueriesConstants.QUERY_BODY_GET_OVERVIEW_LIST,
                resultSetMapping = OverviewListResponseItem.MAPPING_NAME
        ),
        @NamedNativeQuery(
                name = NamedQueriesConstants.QUERY_NAME_GET_OVERVIEW_LIST_COUNT,
                query = NamedQueriesConstants.QUERY_BODY_GET_OVERVIEW_LIST_COUNT,
                resultSetMapping = OverviewListCountResponse.MAPPING_NAME
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = OverviewListResponseItem.MAPPING_NAME,
                classes = @ConstructorResult(
                        targetClass = OverviewListResponseItem.class,
                        columns = {
                                @ColumnResult(name = OverviewListResponseItem.COLUMN_GAME_ID, type = Long.class),
                                @ColumnResult(name = OverviewListResponseItem.COLUMN_TITLE, type = String.class),
                                @ColumnResult(name = OverviewListResponseItem.COLUMN_GAME_DESCRIPTION, type = String.class),
                                @ColumnResult(name = OverviewListResponseItem.COLUMN_RELEASES_COUNT, type = Integer.class),
                                @ColumnResult(name = OverviewListResponseItem.COLUMN_FIRST_RELEASE_DATE, type = Date.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = OverviewListCountResponse.MAPPING_NAME,
                classes = @ConstructorResult(
                        targetClass = OverviewListCountResponse.class,
                        columns = {
                                @ColumnResult(name = OverviewListCountResponse.COLUMN_NAME_COUNT, type = Integer.class)
                        }
                )
        )
})
public class GameEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long gameId;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String gameDescription;

    @OneToMany(mappedBy = "game")
    private List<ReleaseEntity> releases;

    public long getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public List<ReleaseEntity> getReleases() {
        return releases;
    }

    public void setReleases(List<ReleaseEntity> releases) {
        this.releases = releases;
    }
}
