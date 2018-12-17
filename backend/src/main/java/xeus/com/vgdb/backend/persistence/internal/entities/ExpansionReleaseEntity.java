package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "t_expansion_release")
public class ExpansionReleaseEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long expansionReleaseId;

    @Column
    private String releaseName;

    @Column
    private Date releaseDate;

    @Column
    private String releaseRegion;

    @Column(columnDefinition = "text")
    private String releaseDescription;

    @ManyToOne
    @JoinColumn(
            name = "expansion_id",
            foreignKey = @ForeignKey(name = "fk_t_expansion_release_t_expansion_expansion_id")
    )
    private ExpansionEntity expansion;

    @ManyToOne
    @JoinColumn(
            name = "platform_id",
            foreignKey = @ForeignKey(name = "fk_t_expansion_release_t_platform_platform_id")
    )
    private PlatformEntity platform;

    public long getExpansionReleaseId() {
        return expansionReleaseId;
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

    public ExpansionEntity getExpansion() {
        return expansion;
    }

    public void setExpansion(ExpansionEntity expansion) {
        this.expansion = expansion;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }
}
