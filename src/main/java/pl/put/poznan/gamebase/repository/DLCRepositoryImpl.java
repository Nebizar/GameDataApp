package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.DLC;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.QDLC;

/**
 * = DLCRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = DLCRepositoryCustom.class)
@Transactional(readOnly = true)
public class DLCRepositoryImpl extends QueryDslRepositorySupportExt<DLC> implements DLCRepositoryCustom {

    /**
     * Default constructor
     */
    DLCRepositoryImpl() {
        super(DLC.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GAME = "game";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PRICE = "price";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REL___DATE = "rel_date";

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
    public Page<DLC> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QDLC dLC = QDLC.dLC;
        JPQLQuery<DLC> query = from(dLC);
        Path<?>[] paths = new Path<?>[] { dLC.game, dLC.name, dLC.rel_date, dLC.price, dLC.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(GAME, dLC.game).map(NAME, dLC.name).map(REL___DATE, dLC.rel_date).map(PRICE, dLC.price).map(DESCRIPTION, dLC.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, dLC);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DLC> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QDLC dLC = QDLC.dLC;
        JPQLQuery<DLC> query = from(dLC);
        Path<?>[] paths = new Path<?>[] { dLC.game, dLC.name, dLC.rel_date, dLC.price, dLC.description };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(dLC.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(GAME, dLC.game).map(NAME, dLC.name).map(REL___DATE, dLC.rel_date).map(PRICE, dLC.price).map(DESCRIPTION, dLC.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, dLC);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DLC> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable) {
        QDLC dLC = QDLC.dLC;
        JPQLQuery<DLC> query = from(dLC);
        Assert.notNull(game, "game is required");
        query.where(dLC.game.eq(game));
        Path<?>[] paths = new Path<?>[] { dLC.game, dLC.name, dLC.rel_date, dLC.price, dLC.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(GAME, dLC.game).map(NAME, dLC.name).map(REL___DATE, dLC.rel_date).map(PRICE, dLC.price).map(DESCRIPTION, dLC.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, dLC);
    }
}
