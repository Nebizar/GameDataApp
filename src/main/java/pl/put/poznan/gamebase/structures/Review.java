package pl.put.poznan.gamebase.structures;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * = Review
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{game}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{game}")
public class Review {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Reviewer reviewer;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Float user_score;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Float crit_score;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Float gameplay;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Float graphics;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Float audio;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Game game;

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
     * @return Review
     */
    public Review setId(Long id) {
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
     * @return Review
     */
    public Review setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets reviewer value
     *
     * @return Reviewer
     */
    public Reviewer getReviewer() {
        return this.reviewer;
    }

    /**
     * Sets reviewer value
     *
     * @param reviewer
     * @return Review
     */
    public Review setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    /**
     * Gets user_score value
     *
     * @return Float
     */
    public Float getUser_score() {
        return this.user_score;
    }

    /**
     * Sets user_score value
     *
     * @param user_score
     * @return Review
     */
    public Review setUser_score(Float user_score) {
        this.user_score = user_score;
        return this;
    }

    /**
     * Gets crit_score value
     *
     * @return Float
     */
    public Float getCrit_score() {
        return this.crit_score;
    }

    /**
     * Sets crit_score value
     *
     * @param crit_score
     * @return Review
     */
    public Review setCrit_score(Float crit_score) {
        this.crit_score = crit_score;
        return this;
    }

    /**
     * Gets gameplay value
     *
     * @return Float
     */
    public Float getGameplay() {
        return this.gameplay;
    }

    /**
     * Sets gameplay value
     *
     * @param gameplay
     * @return Review
     */
    public Review setGameplay(Float gameplay) {
        this.gameplay = gameplay;
        return this;
    }

    /**
     * Gets graphics value
     *
     * @return Float
     */
    public Float getGraphics() {
        return this.graphics;
    }

    /**
     * Sets graphics value
     *
     * @param graphics
     * @return Review
     */
    public Review setGraphics(Float graphics) {
        this.graphics = graphics;
        return this;
    }

    /**
     * Gets audio value
     *
     * @return Float
     */
    public Float getAudio() {
        return this.audio;
    }

    /**
     * Sets audio value
     *
     * @param audio
     * @return Review
     */
    public Review setAudio(Float audio) {
        this.audio = audio;
        return this;
    }

    /**
     * Gets game value
     *
     * @return Game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets game value
     *
     * @param game
     * @return Review
     */
    public Review setGame(Game game) {
        this.game = game;
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
        if (!(obj instanceof Review)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Review) obj).getId());
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
        return "Review {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", user_score='" + user_score + '\'' + ", crit_score='" + crit_score + '\'' + ", gameplay='" + gameplay + '\'' + ", graphics='" + graphics + '\'' + ", audio='" + audio + '\'' + "}" + super.toString();
    }
}
