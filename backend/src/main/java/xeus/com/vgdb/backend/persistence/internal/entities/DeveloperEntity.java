package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_developer")
public class DeveloperEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long developerId;

    @Column
    private String developerName;

    @ManyToMany(mappedBy = "developers")
    private List<ReleaseEntity> developedGameReleases;

    public long getDeveloperId() {
        return developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public List<ReleaseEntity> getDevelopedGameReleases() {
        return developedGameReleases;
    }

    public void setDevelopedGameReleases(List<ReleaseEntity> developedGameReleases) {
        this.developedGameReleases = developedGameReleases;
    }
}
