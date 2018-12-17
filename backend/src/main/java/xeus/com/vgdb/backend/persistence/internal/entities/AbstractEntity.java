package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Column(columnDefinition = "datetime default current_timestamp")
    private Date createdOn;

    @Column(columnDefinition = "datetime on update current_timestamp")
    private Date modifiedOn;

    @Version
    @Column(columnDefinition = "bigint unsigned default 0")
    private long version;

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public long getVersion() {
        return version;
    }

    @PrePersist
    protected void prePersist() {
        createdOn = new Date(new java.util.Date().getTime());
    }

    @PreUpdate
    protected void preUpdate() {
        modifiedOn = new Date(new java.util.Date().getTime());
    }
}
