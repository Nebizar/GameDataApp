package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.GamePlat;
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
import pl.put.poznan.gamebase.structures.Platform;
import pl.put.poznan.gamebase.structures.QGamePlat;

/**
 * = GamePlatRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = GamePlatRepositoryCustom.class)
@Transactional(readOnly = true)
public class GamePlatRepositoryImpl extends QueryDslRepositorySupportExt<GamePlat> implements GamePlatRepositoryCustom {

    /**
     * Default constructor
     */
    GamePlatRepositoryImpl() {
        super(GamePlat.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PLATFORM = "platform";

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
    public static final String SALES = "sales";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QGamePlat gamePlat = QGamePlat.gamePlat;
        JPQLQuery<GamePlat> query = from(gamePlat);
        Path<?>[] paths = new Path<?>[] { gamePlat.game, gamePlat.price, gamePlat.sales, gamePlat.platform };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(GAME, gamePlat.game).map(PRICE, gamePlat.price).map(SALES, gamePlat.sales).map(PLATFORM, gamePlat.platform);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gamePlat);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QGamePlat gamePlat = QGamePlat.gamePlat;
        JPQLQuery<GamePlat> query = from(gamePlat);
        Path<?>[] paths = new Path<?>[] { gamePlat.game, gamePlat.price, gamePlat.sales, gamePlat.platform };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(gamePlat.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(GAME, gamePlat.game).map(PRICE, gamePlat.price).map(SALES, gamePlat.sales).map(PLATFORM, gamePlat.platform);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gamePlat);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable) {
        QGamePlat gamePlat = QGamePlat.gamePlat;
        JPQLQuery<GamePlat> query = from(gamePlat);
        Assert.notNull(game, "game is required");
        query.where(gamePlat.game.eq(game));
        Path<?>[] paths = new Path<?>[] { gamePlat.game, gamePlat.price, gamePlat.sales, gamePlat.platform };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(GAME, gamePlat.game).map(PRICE, gamePlat.price).map(SALES, gamePlat.sales).map(PLATFORM, gamePlat.platform);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gamePlat);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findByPlatform(Platform platform, GlobalSearch globalSearch, Pageable pageable) {
        QGamePlat gamePlat = QGamePlat.gamePlat;
        JPQLQuery<GamePlat> query = from(gamePlat);
        Assert.notNull(platform, "platform is required");
        query.where(gamePlat.platform.eq(platform));
        Path<?>[] paths = new Path<?>[] { gamePlat.game, gamePlat.price, gamePlat.sales, gamePlat.platform };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(GAME, gamePlat.game).map(PRICE, gamePlat.price).map(SALES, gamePlat.sales).map(PLATFORM, gamePlat.platform);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, gamePlat);
    }
}
