package pl.put.poznan.gamebase.structures;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import io.springlets.format.EntityFormat;

import java.util.Objects;

import org.springframework.util.Assert;

/**
 * = Game
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{title}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{title}")
public class Game {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    @SequenceGenerator(name="game_generator", sequenceName = "game_seq", allocationSize = 1)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String title;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Integer pegi;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar rel_date;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float budget;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "game")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<DLC> dlcs = new HashSet<DLC>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "game")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Review> reviews = new HashSet<Review>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "game")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<GamePlat> platforms = new HashSet<GamePlat>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private GameType gametype;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private DevStudio devstudio;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * Gets id value
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id value
     *
     * @param id
     * @return Game
     */
    public Game setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Gets version value
     *
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Sets version value
     *
     * @param version
     * @return Game
     */
    public Game setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets title value
     *
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title value
     *
     * @param title
     * @return Game
     */
    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets description value
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets description value
     *
     * @param description
     * @return Game
     */
    public Game setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets pegi value
     *
     * @return Integer
     */
    public Integer getPegi() {
        return this.pegi;
    }

    /**
     * Sets pegi value
     *
     * @param pegi
     * @return Game
     */
    public Game setPegi(Integer pegi) {
        this.pegi = pegi;
        return this;
    }

    /**
     * Gets rel_date value
     *
     * @return Calendar
     */
    public Calendar getRel_date() {
        return this.rel_date;
    }

    /**
     * Sets rel_date value
     *
     * @param rel_date
     * @return Game
     */
    public Game setRel_date(Calendar rel_date) {
        this.rel_date = rel_date;
        return this;
    }

    /**
     * Gets budget value
     *
     * @return Float
     */
    public Float getBudget() {
        return this.budget;
    }

    /**
     * Sets budget value
     *
     * @param budget
     * @return Game
     */
    public Game setBudget(Float budget) {
        this.budget = budget;
        return this;
    }

    /**
     * Gets dlcs value
     *
     * @return Set
     */
    public Set<DLC> getDlcs() {
        return this.dlcs;
    }

    /**
     * Sets dlcs value
     *
     * @param dlcs
     * @return Game
     */
    public Game setDlcs(Set<DLC> dlcs) {
        this.dlcs = dlcs;
        return this;
    }

    /**
     * Gets reviews value
     *
     * @return Set
     */
    public Set<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Sets reviews value
     *
     * @param reviews
     * @return Game
     */
    public Game setReviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    /**
     * Gets platforms value
     *
     * @return Set
     */
    public Set<GamePlat> getPlatforms() {
        return this.platforms;
    }

    /**
     * Sets platforms value
     *
     * @param platforms
     * @return Game
     */
    public Game setPlatforms(Set<GamePlat> platforms) {
        this.platforms = platforms;
        return this;
    }

    /**
     * Gets gametype value
     *
     * @return GameType
     */
    public GameType getGametype() {
        return this.gametype;
    }

    /**
     * Sets gametype value
     *
     * @param gametype
     * @return Game
     */
    public Game setGametype(GameType gametype) {
        this.gametype = gametype;
        return this;
    }

    /**
     * Gets devstudio value
     *
     * @return DevStudio
     */
    public DevStudio getDevstudio() {
        return this.devstudio;
    }

    /**
     * Sets devstudio value
     *
     * @param devstudio
     * @return Game
     */
    public Game setDevstudio(DevStudio devstudio) {
        this.devstudio = devstudio;
        return this;
    }

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Game)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Game) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Game {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + ", pegi='" + pegi + '\'' + ", rel_date='" + rel_date == null ? null : java.text.DateFormat.getDateTimeInstance().format(rel_date.getTime()) + '\'' + ", budget='" + budget + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dlcsToAdd
     */
    public void addToDlcs(Iterable<DLC> dlcsToAdd) {
        Assert.notNull(dlcsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (DLC item : dlcsToAdd) {
            this.dlcs.add(item);
            item.setGame(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dlcsToRemove
     */
    public void removeFromDlcs(Iterable<DLC> dlcsToRemove) {
        Assert.notNull(dlcsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (DLC item : dlcsToRemove) {
            this.dlcs.remove(item);
            item.setGame(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewsToAdd
     */
    public void addToReviews(Iterable<Review> reviewsToAdd) {
        Assert.notNull(reviewsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Review item : reviewsToAdd) {
            this.reviews.add(item);
            item.setGame(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewsToRemove
     */
    public void removeFromReviews(Iterable<Review> reviewsToRemove) {
        Assert.notNull(reviewsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Review item : reviewsToRemove) {
            this.reviews.remove(item);
            item.setGame(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformsToAdd
     */
    public void addToPlatforms(Iterable<GamePlat> platformsToAdd) {
        Assert.notNull(platformsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : platformsToAdd) {
            this.platforms.add(item);
            item.setGame(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformsToRemove
     */
    public void removeFromPlatforms(Iterable<GamePlat> platformsToRemove) {
        Assert.notNull(platformsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : platformsToRemove) {
            this.platforms.remove(item);
            item.setGame(null);
        }
    }
}
