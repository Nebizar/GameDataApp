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
 * = Developer
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}, #{surname}")
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat("#{name}, #{surname}")
public class Developer {

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
    private DevStudio devstudio;

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
    private String surname;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float salary;

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
     * @return Developer
     */
    public Developer setId(Long id) {
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
     * @return Developer
     */
    public Developer setVersion(Integer version) {
        this.version = version;
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
     * @return Developer
     */
    public Developer setDevstudio(DevStudio devstudio) {
        this.devstudio = devstudio;
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
     * @return Developer
     */
    public Developer setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets surname value
     *
     * @return String
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets surname value
     *
     * @param surname
     * @return Developer
     */
    public Developer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    /**
     * Gets status value
     *
     * @return String
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets status value
     *
     * @param status
     * @return Developer
     */
    public Developer setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets salary value
     *
     * @return Float
     */
    public Float getSalary() {
        return this.salary;
    }

    /**
     * Sets salary value
     *
     * @param salary
     * @return Developer
     */
    public Developer setSalary(Float salary) {
        this.salary = salary;
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
        if (!(obj instanceof Developer)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Developer) obj).getId());
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
        return "Developer {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", status='" + status + '\'' + ", salary='" + salary + '\'' + "}" + super.toString();
    }
}
