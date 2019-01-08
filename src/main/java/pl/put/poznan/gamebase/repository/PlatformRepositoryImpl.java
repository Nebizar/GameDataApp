package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Platform;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.QPlatform;

/**
 * = PlatformRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = PlatformRepositoryCustom.class)
@Transactional(readOnly = true)
public class PlatformRepositoryImpl extends QueryDslRepositorySupportExt<Platform> implements PlatformRepositoryCustom {

    /**
     * Default constructor
     */
    PlatformRepositoryImpl() {
        super(Platform.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PRODUCENT = "producent";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PREMIERE = "premiere";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SALES = "sales";

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
    public Page<Platform> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QPlatform platform = QPlatform.platform;
        JPQLQuery<Platform> query = from(platform);
        Path<?>[] paths = new Path<?>[] { platform.name, platform.producent, platform.sales, platform.premiere };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, platform.name).map(PRODUCENT, platform.producent).map(SALES, platform.sales).map(PREMIERE, platform.premiere);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Platform> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QPlatform platform = QPlatform.platform;
        JPQLQuery<Platform> query = from(platform);
        Path<?>[] paths = new Path<?>[] { platform.name, platform.producent, platform.sales, platform.premiere };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(platform.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, platform.name).map(PRODUCENT, platform.producent).map(SALES, platform.sales).map(PREMIERE, platform.premiere);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, platform);
    }
}
