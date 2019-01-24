package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "t_release")
public class ReleaseEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long releaseId;

    @Column
    private String releaseName;

    @Column
    private Date releaseDate;

    @Column
    private String releaseRegion;

    @Column(columnDefinition = "text")
    private String releaseDescription;

    @OneToOne
    @JoinColumn(
            name = "game_id",
            columnDefinition = "bigint unsigned",
            foreignKey = @ForeignKey(name = "fk_t_release_t_game_game_id")
    )
    private GameEntity game;

    @OneToOne
    @JoinColumn(
            name = "platform_id",
            columnDefinition = "bigint unsigned",
            foreignKey = @ForeignKey(name = "fk_t_release_t_platform_platform_id")
    )
    private PlatformEntity platform;

    @ManyToMany
    @JoinTable(
            name = "t_release_publishing",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id"),
            foreignKey = @ForeignKey(name = "fk_t_release_publishing_t_release_release_id"),
            inverseForeignKey = @ForeignKey(name = "fk_t_release_publishing_t_publisher_publisher_id")
    )
    private List<PublisherEntity> publishers;

    @ManyToMany
    @JoinTable(
            name = "t_release_development",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"),
            foreignKey = @ForeignKey(name = "fk_t_release_development_t_release_release_id"),
            inverseForeignKey = @ForeignKey(name = "fk_t_release_development_t_developer_developer_id")
    )
    private List<DeveloperEntity> developers;

    @ManyToMany
    @JoinTable(
            name = "t_release_additional_content",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "expansion_id"),
            foreignKey = @ForeignKey(name = "fk_t_rel_add_cont_t_release_release_id"),
            inverseForeignKey = @ForeignKey(name = "tk_t_rel_add_cont_t_expansion_expansion_id")
    )
    private List<ExpansionEntity> includedExpansions;

    public long getReleaseId() {
        return releaseId;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseRegion() {
        return releaseRegion;
    }

    public void setReleaseRegion(String releaseRegion) {
        this.releaseRegion = releaseRegion;
    }

    public String getReleaseDescription() {
        return releaseDescription;
    }

    public void setReleaseDescription(String releaseDescription) {
        this.releaseDescription = releaseDescription;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public List<PublisherEntity> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PublisherEntity> publishers) {
        this.publishers = publishers;
    }

    public List<DeveloperEntity> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperEntity> developers) {
        this.developers = developers;
    }

    public List<ExpansionEntity> getIncludedExpansions() {
        return includedExpansions;
    }

    public void setIncludedExpansions(List<ExpansionEntity> includedExpansions) {
        this.includedExpansions = includedExpansions;
    }
}
