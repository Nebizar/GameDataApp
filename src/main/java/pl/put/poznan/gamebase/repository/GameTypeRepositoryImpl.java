package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.GameType;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.QGameType;

/**
 * = GameTypeRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = GameTypeRepositoryCustom.class)
@Transactional(readOnly = true)
public class GameTypeRepositoryImpl extends QueryDslRepositorySupportExt<GameType> implements GameTypeRepositoryCustom {

    /**
     * Default constructor
     */
    GameTypeRepositoryImpl() {
        super(GameType.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

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
    public Page<GameType> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QGameType gameType = QGameType.gameType;
        JPQLQuery<GameType> query = from(gameType);
        Path<?>[] paths = new Path<?>[] { gameType.name, gameType.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, gameType.name).map(DESCRIPTION, gameType.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gameType);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GameType> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QGameType gameType = QGameType.gameType;
        JPQLQuery<GameType> query = from(gameType);
        Path<?>[] paths = new Path<?>[] { gameType.name, gameType.description };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(gameType.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, gameType.name).map(DESCRIPTION, gameType.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gameType);
    }
}
