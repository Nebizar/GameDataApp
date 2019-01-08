package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Game;
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
import pl.put.poznan.gamebase.structures.GameType;
import pl.put.poznan.gamebase.structures.QGame;

/**
 * = GameRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = GameRepositoryCustom.class)
@Transactional(readOnly = true)
public class GameRepositoryImpl extends QueryDslRepositorySupportExt<Game> implements GameRepositoryCustom {

    /**
     * Default constructor
     */
    GameRepositoryImpl() {
        super(Game.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PEGI = "pegi";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BUDGET = "budget";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TITLE = "title";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DEVSTUDIO = "devstudio";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REL___DATE = "rel_date";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GAMETYPE = "gametype";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Game> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QGame game = QGame.game;
        JPQLQuery<Game> query = from(game);
        Path<?>[] paths = new Path<?>[] { game.title, game.description, game.pegi, game.rel_date, game.budget, game.gametype, game.devstudio };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(TITLE, game.title).map(DESCRIPTION, game.description).map(PEGI, game.pegi).map(REL___DATE, game.rel_date).map(BUDGET, game.budget).map(GAMETYPE, game.gametype).map(DEVSTUDIO, game.devstudio);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Game> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QGame game = QGame.game;
        JPQLQuery<Game> query = from(game);
        Path<?>[] paths = new Path<?>[] { game.title, game.description, game.pegi, game.rel_date, game.budget, game.gametype, game.devstudio };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(game.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(TITLE, game.title).map(DESCRIPTION, game.description).map(PEGI, game.pegi).map(REL___DATE, game.rel_date).map(BUDGET, game.budget).map(GAMETYPE, game.gametype).map(DEVSTUDIO, game.devstudio);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Game> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable) {
        QGame game = QGame.game;
        JPQLQuery<Game> query = from(game);
        Assert.notNull(devstudio, "devstudio is required");
        query.where(game.devstudio.eq(devstudio));
        Path<?>[] paths = new Path<?>[] { game.title, game.description, game.pegi, game.rel_date, game.budget, game.gametype, game.devstudio };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(TITLE, game.title).map(DESCRIPTION, game.description).map(PEGI, game.pegi).map(REL___DATE, game.rel_date).map(BUDGET, game.budget).map(GAMETYPE, game.gametype).map(DEVSTUDIO, game.devstudio);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Game> findByGametype(GameType gametype, GlobalSearch globalSearch, Pageable pageable) {
        QGame game = QGame.game;
        JPQLQuery<Game> query = from(game);
        Assert.notNull(gametype, "gametype is required");
        query.where(game.gametype.eq(gametype));
        Path<?>[] paths = new Path<?>[] { game.title, game.description, game.pegi, game.rel_date, game.budget, game.gametype, game.devstudio };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(TITLE, game.title).map(DESCRIPTION, game.description).map(PEGI, game.pegi).map(REL___DATE, game.rel_date).map(BUDGET, game.budget).map(GAMETYPE, game.gametype).map(DEVSTUDIO, game.devstudio);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, game);
    }
}
