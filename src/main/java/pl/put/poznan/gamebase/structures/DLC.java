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
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * = DLC
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}, #{game}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{name}, #{game}")
public class DLC {

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
    private Game game;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String name;

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
    private Float price;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

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
     * @return DLC
     */
    public DLC setId(Long id) {
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
     * @return DLC
     */
    public DLC setVersion(Integer version) {
        this.version = version;
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
     * @return DLC
     */
    public DLC setGame(Game game) {
        this.game = game;
        return this;
    }

    /**
     * Gets name value
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name value
     *
     * @param name
     * @return DLC
     */
    public DLC setName(String name) {
        this.name = name;
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
     * @return DLC
     */
    public DLC setRel_date(Calendar rel_date) {
        this.rel_date = rel_date;
        return this;
    }

    /**
     * Gets price value
     *
     * @return Float
     */
    public Float getPrice() {
        return this.price;
    }

    /**
     * Sets price value
     *
     * @param price
     * @return DLC
     */
    public DLC setPrice(Float price) {
        this.price = price;
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
     * @return DLC
     */
    public DLC setDescription(String description) {
        this.description = description;
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
        if (!(obj instanceof DLC)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((DLC) obj).getId());
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
        return "DLC {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", rel_date='" + rel_date == null ? null : java.text.DateFormat.getDateTimeInstance().format(rel_date.getTime()) + '\'' + ", price='" + price + '\'' + ", description='" + description + '\'' + "}" + super.toString();
    }
}
