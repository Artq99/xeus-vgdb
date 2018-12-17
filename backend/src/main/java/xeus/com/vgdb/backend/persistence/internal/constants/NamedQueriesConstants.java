package xeus.com.vgdb.backend.persistence.internal.constants;

/**
 * Constants for named queries.
 *
 * @author Artur Matracki
 */
public class NamedQueriesConstants {

    /**
     * The name of the query <code>GetOverviewList</code>.
     */
    public static final String QUERY_NAME_GET_OVERVIEW_LIST = "GetOverviewList";

    /**
     * The body of the query <code>GetOverviewList</code>.
     */
    public static final String QUERY_BODY_GET_OVERVIEW_LIST = "" +
        "SELECT " +
        "    t_game.game_id, " +
        "    t_game.title, " +
        "    t_game.game_description, " +
        "    COUNT(t_release.release_id) AS releases_count, " +
        "    MIN(t_release.release_date) AS first_release_date " +
        "FROM t_release " +
        "LEFT JOIN t_game USING(game_id) " +
        "GROUP BY game_id";
}
