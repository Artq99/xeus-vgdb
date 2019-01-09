package xeus.com.vgdb.backend.persistence.access.internal.response;

import java.util.Date;

/**
 * <p>The class representing a single element of the response from the query <code>GetOverviewList</code>.</p>
 *
 * <p>Query defined in {@link xeus.com.vgdb.backend.persistence.internal.entities.GameEntity}.</p>
 *
 * @author Artur Matracki
 */
public class OverviewListResponseItem {

    /**
     * The name of the mapping to this class.
     */
    public static final String MAPPING_NAME = "OverviewListElementMapping";

    /**
     * The name of the query column mapped to the field <code>gameId</code>.
     */
    public static final String COLUMN_GAME_ID = "game_id";

    /**
     * The name of the query column mapped to the field <code>title</code>.
     */
    public static final String COLUMN_TITLE = "title";

    /**
     * The name of the query column mapped to the field <code>gameDescription</code>.
     */
    public static final String COLUMN_GAME_DESCRIPTION = "game_description";

    /**
     * The name of the query column mapped to the field <code>releasesCount</code>.
     */
    public static final String COLUMN_RELEASES_COUNT = "releases_count";

    /**
     * The name of the query column mapped to the field <code>firstReleaseDate</code>.
     */
    public static final String COLUMN_FIRST_RELEASE_DATE = "first_release_date";

    private Long gameId;
    private String title;
    private String gameDescription;
    private Integer releasesCount;
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
    public OverviewListResponseItem(Long gameId, String title, String gameDescription, Integer releasesCount,
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

    public Integer getReleasesCount() {
        return releasesCount;
    }

    public void setReleasesCount(Integer releasesCount) {
        this.releasesCount = releasesCount;
    }

    public Date getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(Date firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

}
