package pl.put.poznan.gamebase.structures;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import io.springlets.format.EntityFormat;
import java.util.Objects;

import org.springframework.util.Assert;

/**
 * = Reviewer
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{nick}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{nick}")
public class Reviewer {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewer_generator")
    @SequenceGenerator(name="reviewer_generator", sequenceName = "reviewer_seq", allocationSize = 1)
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
    private String nick;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private Boolean critic;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String affility;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "reviewer")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Review> reviews = new HashSet<Review>();

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
     * @return Reviewer
     */
    public Reviewer setId(Long id) {
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
     * @return Reviewer
     */
    public Reviewer setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets nick value
     *
     * @return String
     */
    public String getNick() {
        return this.nick;
    }

    /**
     * Sets nick value
     *
     * @param nick
     * @return Reviewer
     */
    public Reviewer setNick(String nick) {
        this.nick = nick;
        return this;
    }

    /**
     * Gets critic value
     *
     * @return Boolean
     */
    public Boolean getCritic() {
        return this.critic;
    }

    /**
     * Sets critic value
     *
     * @param critic
     * @return Reviewer
     */
    public Reviewer setCritic(Boolean critic) {
        this.critic = critic;
        return this;
    }

    /**
     * Gets affility value
     *
     * @return String
     */
    public String getAffility() {
        return this.affility;
    }

    /**
     * Sets affility value
     *
     * @param affility
     * @return Reviewer
     */
    public Reviewer setAffility(String affility) {
        this.affility = affility;
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
     * @return Reviewer
     */
    public Reviewer setReviews(Set<Review> reviews) {
        this.reviews = reviews;
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
        if (!(obj instanceof Reviewer)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Reviewer) obj).getId());
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
        return "Reviewer {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", nick='" + nick + '\'' + ", critic='" + critic + '\'' + ", affility='" + affility + '\'' + "}" + super.toString();
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
            item.setReviewer(this);
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
            item.setReviewer(null);
        }
    }
}
