package xeus.com.vgdb.backend.persistence.internal.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_expansion")
public class ExpansionEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long expansionId;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String expansionDescription;

    @OneToOne
    @JoinColumn(
            name = "game_id",
            columnDefinition = "bigint unsigned",
            foreignKey = @ForeignKey(name = "fk_t_expansion_t_game_game_id")
    )
    private GameEntity game;

    // standaloneReleases

    @ManyToMany(mappedBy = "includedExpansions")
    private List<ReleaseEntity> containingGameReleases;

    public long getExpansionId() {
        return expansionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpansionDescription() {
        return expansionDescription;
    }

    public void setExpansionDescription(String expansionDescription) {
        this.expansionDescription = expansionDescription;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
