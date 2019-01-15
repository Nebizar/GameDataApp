package pl.put.poznan.gamebase.structures;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import io.springlets.format.EntityFormat;

import java.util.Objects;

import org.springframework.util.Assert;

/**
 * = DevStudio
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{name}")
public class DevStudio {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devStudio_generator")
    @SequenceGenerator(name="devStudio_generator", sequenceName = "devStudio_seq", allocationSize = 1)
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
    private String country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String main_loc;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer devs_count;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float valueOf;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "devstudio")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Game> games = new HashSet<Game>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "devstudio")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Developer> developers = new HashSet<Developer>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Publisher publisher;

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
     * @return DevStudio
     */
    public DevStudio setId(Long id) {
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
     * @return DevStudio
     */
    public DevStudio setVersion(Integer version) {
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
     * @return DevStudio
     */
    public DevStudio setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets country value
     *
     * @return String
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets country value
     *
     * @param country
     * @return DevStudio
     */
    public DevStudio setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Gets main_loc value
     *
     * @return String
     */
    public String getMain_loc() {
        return this.main_loc;
    }

    /**
     * Sets main_loc value
     *
     * @param main_loc
     * @return DevStudio
     */
    public DevStudio setMain_loc(String main_loc) {
        this.main_loc = main_loc;
        return this;
    }

    /**
     * Gets devs_count value
     *
     * @return Integer
     */
    public Integer getDevs_count() {
        return this.devs_count;
    }

    /**
     * Sets devs_count value
     *
     * @param devs_count
     * @return DevStudio
     */
    public DevStudio setDevs_count(Integer devs_count) {
        this.devs_count = devs_count;
        return this;
    }

    /**
     * Gets valueOf value
     *
     * @return Float
     */
    public Float getValueOf() {
        return this.valueOf;
    }

    /**
     * Sets valueOf value
     *
     * @param valueOf
     * @return DevStudio
     */
    public DevStudio setValueOf(Float valueOf) {
        this.valueOf = valueOf;
        return this;
    }

    /**
     * Gets games value
     *
     * @return Set
     */
    public Set<Game> getGames() {
        return this.games;
    }

    /**
     * Sets games value
     *
     * @param games
     * @return DevStudio
     */
    public DevStudio setGames(Set<Game> games) {
        this.games = games;
        return this;
    }

    /**
     * Gets developers value
     *
     * @return Set
     */
    public Set<Developer> getDevelopers() {
        return this.developers;
    }

    /**
     * Sets developers value
     *
     * @param developers
     * @return DevStudio
     */
    public DevStudio setDevelopers(Set<Developer> developers) {
        this.developers = developers;
        return this;
    }

    /**
     * Gets publisher value
     *
     * @return Publisher
     */
    public Publisher getPublisher() {
        return this.publisher;
    }

    /**
     * Sets publisher value
     *
     * @param publisher
     * @return DevStudio
     */
    public DevStudio setPublisher(Publisher publisher) {
        this.publisher = publisher;
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
        if (!(obj instanceof DevStudio)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((DevStudio) obj).getId());
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
        return "DevStudio {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", country='" + country + '\'' + ", main_loc='" + main_loc + '\'' + ", devs_count='" + devs_count + '\'' + ", valueOf='" + valueOf + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamesToAdd
     */
    public void addToGames(Iterable<Game> gamesToAdd) {
        Assert.notNull(gamesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Game item : gamesToAdd) {
            this.games.add(item);
            item.setDevstudio(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamesToRemove
     */
    public void removeFromGames(Iterable<Game> gamesToRemove) {
        Assert.notNull(gamesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Game item : gamesToRemove) {
            this.games.remove(item);
            item.setDevstudio(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developersToAdd
     */
    public void addToDevelopers(Iterable<Developer> developersToAdd) {
        Assert.notNull(developersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Developer item : developersToAdd) {
            this.developers.add(item);
            item.setDevstudio(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developersToRemove
     */
    public void removeFromDevelopers(Iterable<Developer> developersToRemove) {
        Assert.notNull(developersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Developer item : developersToRemove) {
            this.developers.remove(item);
            item.setDevstudio(null);
        }
    }
}
