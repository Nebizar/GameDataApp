package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Publisher;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.QPublisher;

/**
 * = PublisherRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = PublisherRepositoryCustom.class)
@Transactional(readOnly = true)
public class PublisherRepositoryImpl extends QueryDslRepositorySupportExt<Publisher> implements PublisherRepositoryCustom {

    /**
     * Default constructor
     */
    PublisherRepositoryImpl() {
        super(Publisher.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String VALUE_OF = "valueOf";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MAIN___LOC = "main_loc";

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
    public Page<Publisher> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QPublisher publisher = QPublisher.publisher;
        JPQLQuery<Publisher> query = from(publisher);
        Path<?>[] paths = new Path<?>[] { publisher.name, publisher.valueOf, publisher.main_loc };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, publisher.name).map(VALUE_OF, publisher.valueOf).map(MAIN___LOC, publisher.main_loc);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Publisher> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QPublisher publisher = QPublisher.publisher;
        JPQLQuery<Publisher> query = from(publisher);
        Path<?>[] paths = new Path<?>[] { publisher.name, publisher.valueOf, publisher.main_loc };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(publisher.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, publisher.name).map(VALUE_OF, publisher.valueOf).map(MAIN___LOC, publisher.main_loc);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, publisher);
    }
}
