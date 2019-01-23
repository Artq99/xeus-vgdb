package xeus.com.vgdb.backend.persistence.access.internal.response;

import java.util.Date;

/**
 * <p>The class representing a single element of the response from the query <code>GetOverviewList</code>.</p>
 *
 * @author Artur Matracki
 */
public class OverviewListResponseItem {

    private Long gameId;
    private String title;
    private String gameDescription;
    private Long releasesCount;
    private Date firstReleaseDate;

    /**
     * The constructor compliant with the mapping.
     *
     * @param gameId           column <code>game_id</code>
     * @param title            column <code>title</code>
     * @param gameDescription  column <code>game_description</code>
     * @param releasesCount    column <code>release_count</code>
     * @param firstReleaseDate column <code>first_release_date</code>
     */
    public OverviewListResponseItem(Long gameId, String title, String gameDescription, Long releasesCount,
                                    Date firstReleaseDate) {

        this.gameId = gameId;
        this.title = title;
        this.gameDescription = gameDescription;
        this.releasesCount = releasesCount;
        this.firstReleaseDate = firstReleaseDate;
    }

    public Long getGameId() {

        return gameId;
    }

    public void setGameId(Long gameId) {

        this.gameId = gameId;
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

    public Long getReleasesCount() {

        return releasesCount;
    }

    public void setReleasesCount(Long releasesCount) {

        this.releasesCount = releasesCount;
    }

    public Date getFirstReleaseDate() {

        return firstReleaseDate;
    }

    public void setFirstReleaseDate(Date firstReleaseDate) {

        this.firstReleaseDate = firstReleaseDate;
    }

}
