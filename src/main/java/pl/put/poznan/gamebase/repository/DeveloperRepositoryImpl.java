package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Developer;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.QDeveloper;

/**
 * = DeveloperRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = DeveloperRepositoryCustom.class)
@Transactional(readOnly = true)
public class DeveloperRepositoryImpl extends QueryDslRepositorySupportExt<Developer> implements DeveloperRepositoryCustom {

    /**
     * Default constructor
     */
    DeveloperRepositoryImpl() {
        super(Developer.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SURNAME = "surname";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String STATUS = "status";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SALARY = "salary";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DEVSTUDIO = "devstudio";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QDeveloper developer = QDeveloper.developer;
        JPQLQuery<Developer> query = from(developer);
        Path<?>[] paths = new Path<?>[] { developer.devstudio, developer.name, developer.surname, developer.status, developer.salary };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DEVSTUDIO, developer.devstudio).map(NAME, developer.name).map(SURNAME, developer.surname).map(STATUS, developer.status).map(SALARY, developer.salary);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, developer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QDeveloper developer = QDeveloper.developer;
        JPQLQuery<Developer> query = from(developer);
        Path<?>[] paths = new Path<?>[] { developer.devstudio, developer.name, developer.surname, developer.status, developer.salary };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(developer.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(DEVSTUDIO, developer.devstudio).map(NAME, developer.name).map(SURNAME, developer.surname).map(STATUS, developer.status).map(SALARY, developer.salary);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, developer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable) {
        QDeveloper developer = QDeveloper.developer;
        JPQLQuery<Developer> query = from(developer);
        Assert.notNull(devstudio, "devstudio is required");
        query.where(developer.devstudio.eq(devstudio));
        Path<?>[] paths = new Path<?>[] { developer.devstudio, developer.name, developer.surname, developer.status, developer.salary };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DEVSTUDIO, developer.devstudio).map(NAME, developer.name).map(SURNAME, developer.surname).map(STATUS, developer.status).map(SALARY, developer.salary);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, developer);
    }
}
