package xeus.com.vgdb.backend.persistence.dto;

import java.util.GregorianCalendar;

public class OverviewListElementDTO {

    private Long gameId;
    private String title;
    private String gameDescription;
    private Integer releasesCount;
    private GregorianCalendar firstReleaseDate;

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

    public GregorianCalendar getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(GregorianCalendar firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }
}
