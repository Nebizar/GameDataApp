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
 * = Publisher
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{name}")
@Table(name = "publisher", uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"}),},
indexes = {
        @Index(name = "publisher_id",  columnList="id", unique = true)})
public class Publisher {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name="publisher_generator", sequenceName = "publisher_seq", allocationSize = 1)
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
    @NumberFormat
    private Float valueOf;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String main_loc;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "publisher")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<DevStudio> dev_studios = new HashSet<DevStudio>();

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
     * @return Publisher
     */
    public Publisher setId(Long id) {
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
     * @return Publisher
     */
    public Publisher setVersion(Integer version) {
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
     * @return Publisher
     */
    public Publisher setName(String name) {
        this.name = name;
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
     * @return Publisher
     */
    public Publisher setValueOf(Float valueOf) {
        this.valueOf = valueOf;
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
     * @return Publisher
     */
    public Publisher setMain_loc(String main_loc) {
        this.main_loc = main_loc;
        return this;
    }

    /**
     * Gets dev_studios value
     *
     * @return Set
     */
    public Set<DevStudio> getDev_studios() {
        return this.dev_studios;
    }

    /**
     * Sets dev_studios value
     *
     * @param dev_studios
     * @return Publisher
     */
    public Publisher setDev_studios(Set<DevStudio> dev_studios) {
        this.dev_studios = dev_studios;
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
        if (!(obj instanceof Publisher)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Publisher) obj).getId());
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
        return "Publisher {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", valueOf='" + valueOf + '\'' + ", main_loc='" + main_loc + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dev_studiosToAdd
     */
    public void addToDev_studios(Iterable<DevStudio> dev_studiosToAdd) {
        Assert.notNull(dev_studiosToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (DevStudio item : dev_studiosToAdd) {
            this.dev_studios.add(item);
            item.setPublisher(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dev_studiosToRemove
     */
    public void removeFromDev_studios(Iterable<DevStudio> dev_studiosToRemove) {
        Assert.notNull(dev_studiosToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (DevStudio item : dev_studiosToRemove) {
            this.dev_studios.remove(item);
            item.setPublisher(null);
        }
    }
}
