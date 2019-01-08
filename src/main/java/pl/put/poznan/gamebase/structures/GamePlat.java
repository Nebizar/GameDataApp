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
import org.springframework.format.annotation.NumberFormat;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * = GamePlat
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{game}, #{platform}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{game}, #{platform}")
public class GamePlat {

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
    @NumberFormat
    private Float price;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer sales;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Platform platform;

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
     * @return GamePlat
     */
    public GamePlat setId(Long id) {
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
     * @return GamePlat
     */
    public GamePlat setVersion(Integer version) {
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
     * @return GamePlat
     */
    public GamePlat setGame(Game game) {
        this.game = game;
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
     * @return GamePlat
     */
    public GamePlat setPrice(Float price) {
        this.price = price;
        return this;
    }

    /**
     * Gets sales value
     *
     * @return Integer
     */
    public Integer getSales() {
        return this.sales;
    }

    /**
     * Sets sales value
     *
     * @param sales
     * @return GamePlat
     */
    public GamePlat setSales(Integer sales) {
        this.sales = sales;
        return this;
    }

    /**
     * Gets platform value
     *
     * @return Platform
     */
    public Platform getPlatform() {
        return this.platform;
    }

    /**
     * Sets platform value
     *
     * @param platform
     * @return GamePlat
     */
    public GamePlat setPlatform(Platform platform) {
        this.platform = platform;
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
        if (!(obj instanceof GamePlat)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((GamePlat) obj).getId());
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
        return "GamePlat {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", price='" + price + '\'' + ", sales='" + sales + '\'' + "}" + super.toString();
    }
}
