package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.util.List;

/**
 * The entity representing the table <code>t_game</code> from the database.
 *
 * @author Artur Matracki
 */
@Entity
@Table(name = "t_game")
@NamedQueries({
        @NamedQuery(
                name = "GetOverviewList",
                query = "" +
                        "SELECT new" +
                        "    xeus.com.vgdb.backend.persistence.access.internal.response.OverviewListResponseItem(" +
                        "        g.gameId, " +
                        "        g.title, " +
                        "        g.gameDescription, " +
                        "        COUNT(r.releaseId), " +
                        "        MIN(r.releaseDate)" +
                        "    ) " +
                        "FROM GameEntity g " +
                        "LEFT JOIN g.releases r " +
                        "GROUP BY g.gameId " +
                        "ORDER BY g.title"
        ),
        @NamedQuery(
                name = "GetOverviewListCount",
                query = "SELECT COUNT(g.gameId) FROM GameEntity g"
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
