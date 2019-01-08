package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.DevStudio;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.put.poznan.gamebase.structures.Publisher;
import pl.put.poznan.gamebase.structures.QDevStudio;

/**
 * = DevStudioRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = DevStudioRepositoryCustom.class)
@Transactional(readOnly = true)
public class DevStudioRepositoryImpl extends QueryDslRepositorySupportExt<DevStudio> implements DevStudioRepositoryCustom {

    /**
     * Default constructor
     */
    DevStudioRepositoryImpl() {
        super(DevStudio.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PUBLISHER = "publisher";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COUNTRY = "country";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MAIN___LOC = "main_loc";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String VALUE_OF = "valueOf";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DEVS___COUNT = "devs_count";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QDevStudio devStudio = QDevStudio.devStudio;
        JPQLQuery<DevStudio> query = from(devStudio);
        Path<?>[] paths = new Path<?>[] { devStudio.name, devStudio.country, devStudio.main_loc, devStudio.devs_count, devStudio.valueOf, devStudio.publisher };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, devStudio.name).map(COUNTRY, devStudio.country).map(MAIN___LOC, devStudio.main_loc).map(DEVS___COUNT, devStudio.devs_count).map(VALUE_OF, devStudio.valueOf).map(PUBLISHER, devStudio.publisher);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QDevStudio devStudio = QDevStudio.devStudio;
        JPQLQuery<DevStudio> query = from(devStudio);
        Path<?>[] paths = new Path<?>[] { devStudio.name, devStudio.country, devStudio.main_loc, devStudio.devs_count, devStudio.valueOf, devStudio.publisher };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(devStudio.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, devStudio.name).map(COUNTRY, devStudio.country).map(MAIN___LOC, devStudio.main_loc).map(DEVS___COUNT, devStudio.devs_count).map(VALUE_OF, devStudio.valueOf).map(PUBLISHER, devStudio.publisher);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findByPublisher(Publisher publisher, GlobalSearch globalSearch, Pageable pageable) {
        QDevStudio devStudio = QDevStudio.devStudio;
        JPQLQuery<DevStudio> query = from(devStudio);
        Assert.notNull(publisher, "publisher is required");
        query.where(devStudio.publisher.eq(publisher));
        Path<?>[] paths = new Path<?>[] { devStudio.name, devStudio.country, devStudio.main_loc, devStudio.devs_count, devStudio.valueOf, devStudio.publisher };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, devStudio.name).map(COUNTRY, devStudio.country).map(MAIN___LOC, devStudio.main_loc).map(DEVS___COUNT, devStudio.devs_count).map(VALUE_OF, devStudio.valueOf).map(PUBLISHER, devStudio.publisher);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, devStudio);
    }
}
