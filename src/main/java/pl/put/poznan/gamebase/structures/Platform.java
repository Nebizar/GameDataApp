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
 * = Platform
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}")
@RooEquals(isJpaEntity = true)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "functionAvarage",
                procedureName = "avaragepriceforplatform",
                parameters = {
                        @StoredProcedureParameter(name = "platform", mode = ParameterMode.IN, type = Long.class)
                }
        )
})
@Entity
@EntityFormat("#{name}")
public class Platform {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_generator")
    @SequenceGenerator(name="platform_generator", sequenceName = "platform_seq", allocationSize = 1)
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
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String producent;

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
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar premiere;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "platform")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<GamePlat> games = new HashSet<GamePlat>();

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
     * @return Platform
     */
    public Platform setId(Long id) {
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
     * @return Platform
     */
    public Platform setVersion(Integer version) {
        this.version = version;
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
     * @return Platform
     */
    public Platform setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets producent value
     *
     * @return String
     */
    public String getProducent() {
        return this.producent;
    }

    /**
     * Sets producent value
     *
     * @param producent
     * @return Platform
     */
    public Platform setProducent(String producent) {
        this.producent = producent;
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
     * @return Platform
     */
    public Platform setSales(Integer sales) {
        this.sales = sales;
        return this;
    }

    /**
     * Gets premiere value
     *
     * @return Calendar
     */
    public Calendar getPremiere() {
        return this.premiere;
    }

    /**
     * Sets premiere value
     *
     * @param premiere
     * @return Platform
     */
    public Platform setPremiere(Calendar premiere) {
        this.premiere = premiere;
        return this;
    }

    /**
     * Gets games value
     *
     * @return Set
     */
    public Set<GamePlat> getGames() {
        return this.games;
    }

    /**
     * Sets games value
     *
     * @param games
     * @return Platform
     */
    public Platform setGames(Set<GamePlat> games) {
        this.games = games;
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
        if (!(obj instanceof Platform)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Platform) obj).getId());
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
        return "Platform {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", producent='" + producent + '\'' + ", sales='" + sales + '\'' + ", premiere='" + premiere == null ? null : java.text.DateFormat.getDateTimeInstance().format(premiere.getTime()) + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamesToAdd
     */
    public void addToGames(Iterable<GamePlat> gamesToAdd) {
        Assert.notNull(gamesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : gamesToAdd) {
            this.games.add(item);
            item.setPlatform(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamesToRemove
     */
    public void removeFromGames(Iterable<GamePlat> gamesToRemove) {
        Assert.notNull(gamesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : gamesToRemove) {
            this.games.remove(item);
            item.setPlatform(null);
        }
    }
}
