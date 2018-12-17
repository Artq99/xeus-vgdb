package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_platform")
public class PlatformEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long platformId;

    @Column(columnDefinition = "varchar(255)")
    private String platformName;

    @OneToMany(mappedBy = "platform")
    private List<ReleaseEntity> gamesReleased;

    public long getPlatformId() {
        return platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
