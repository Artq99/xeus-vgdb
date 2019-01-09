package xeus.com.vgdb.backend.persistence.access.internal.response;

/**
 * <p>Response object for the query <code>GetOverviewListCount</code>.</p>
 *
 * <p>Query defined in the entity {@link xeus.com.vgdb.backend.persistence.internal.entities.GameEntity}.</p>
 *
 * @author Artur Matracki
 */
public class OverviewListCountResponse {

    /**
     * The name for the mapping to this class.
     */
    public static final String MAPPING_NAME = "OverviewListCountMapping";

    /**
     * Response column name <code>count</code>.
     */
    public static final String COLUMN_NAME_COUNT = "count";

    private Integer count;

    /**
     * The constructor compliant with the mapping.
     *
     * @param count column <code>count</code>
     */
    public OverviewListCountResponse(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
