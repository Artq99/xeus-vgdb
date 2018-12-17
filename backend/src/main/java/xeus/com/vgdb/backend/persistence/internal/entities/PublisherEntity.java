package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_publisher")
public class PublisherEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long publisherId;

    @Column
    private String publisherName;

    @ManyToMany(mappedBy = "publishers")
    private List<ReleaseEntity> publishedGameReleases;

    public long getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<ReleaseEntity> getPublishedGameReleases() {
        return publishedGameReleases;
    }

    public void setPublishedGameReleases(List<ReleaseEntity> publishedGameReleases) {
        this.publishedGameReleases = publishedGameReleases;
    }
}
