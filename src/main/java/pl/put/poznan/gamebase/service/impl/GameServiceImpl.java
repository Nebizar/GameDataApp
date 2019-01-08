package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.GameService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.GameRepository;
import pl.put.poznan.gamebase.service.api.DLCService;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.DLC;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.GameType;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = GameServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = GameService.class)
@Service
@Transactional(readOnly = true)
public class GameServiceImpl implements GameService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatService gamePlatService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameRepository gameRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DLCService dLCService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewService reviewService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gameRepository
     * @param dLCService
     * @param gamePlatService
     * @param reviewService
     */
    @Autowired
    public GameServiceImpl(GameRepository gameRepository, @Lazy DLCService dLCService, @Lazy GamePlatService gamePlatService, @Lazy ReviewService reviewService) {
        setGameRepository(gameRepository);
        setDLCService(dLCService);
        setGamePlatService(gamePlatService);
        setReviewService(reviewService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GameRepository
     */
    public GameRepository getGameRepository() {
        return gameRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameRepository
     */
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return DLCService
     */
    public DLCService getDLCService() {
        return dLCService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dLCService
     */
    public void setDLCService(DLCService dLCService) {
        this.dLCService = dLCService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GamePlatService
     */
    public GamePlatService getGamePlatService() {
        return gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlatService
     */
    public void setGamePlatService(GamePlatService gamePlatService) {
        this.gamePlatService = gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewService
     */
    public ReviewService getReviewService() {
        return reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewService
     */
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Game game) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcsToAdd
     * @return Game
     */
    @Transactional
    public Game addToDlcs(Game game, Iterable<Long> dlcsToAdd) {
        List<DLC> dlcs = getDLCService().findAll(dlcsToAdd);
        game.addToDlcs(dlcs);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platformsToAdd
     * @return Game
     */
    @Transactional
    public Game addToPlatforms(Game game, Iterable<Long> platformsToAdd) {
        List<GamePlat> platforms = getGamePlatService().findAll(platformsToAdd);
        game.addToPlatforms(platforms);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToAdd
     * @return Game
     */
    @Transactional
    public Game addToReviews(Game game, Iterable<Long> reviewsToAdd) {
        List<Review> reviews = getReviewService().findAll(reviewsToAdd);
        game.addToReviews(reviews);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcsToRemove
     * @return Game
     */
    @Transactional
    public Game removeFromDlcs(Game game, Iterable<Long> dlcsToRemove) {
        List<DLC> dlcs = getDLCService().findAll(dlcsToRemove);
        game.removeFromDlcs(dlcs);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platformsToRemove
     * @return Game
     */
    @Transactional
    public Game removeFromPlatforms(Game game, Iterable<Long> platformsToRemove) {
        List<GamePlat> platforms = getGamePlatService().findAll(platformsToRemove);
        game.removeFromPlatforms(platforms);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToRemove
     * @return Game
     */
    @Transactional
    public Game removeFromReviews(Game game, Iterable<Long> reviewsToRemove) {
        List<Review> reviews = getReviewService().findAll(reviewsToRemove);
        game.removeFromReviews(reviews);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcs
     * @return Game
     */
    @Transactional
    public Game setDlcs(Game game, Iterable<Long> dlcs) {
        List<DLC> items = getDLCService().findAll(dlcs);
        Set<DLC> currents = game.getDlcs();
        Set<DLC> toRemove = new HashSet<DLC>();
        for (Iterator<DLC> iterator = currents.iterator(); iterator.hasNext(); ) {
            DLC nextDLC = iterator.next();
            if (items.contains(nextDLC)) {
                items.remove(nextDLC);
            } else {
                toRemove.add(nextDLC);
            }
        }
        game.removeFromDlcs(toRemove);
        game.addToDlcs(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        game.setVersion(game.getVersion() + 1);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platforms
     * @return Game
     */
    @Transactional
    public Game setPlatforms(Game game, Iterable<Long> platforms) {
        List<GamePlat> items = getGamePlatService().findAll(platforms);
        Set<GamePlat> currents = game.getPlatforms();
        Set<GamePlat> toRemove = new HashSet<GamePlat>();
        for (Iterator<GamePlat> iterator = currents.iterator(); iterator.hasNext(); ) {
            GamePlat nextGamePlat = iterator.next();
            if (items.contains(nextGamePlat)) {
                items.remove(nextGamePlat);
            } else {
                toRemove.add(nextGamePlat);
            }
        }
        game.removeFromPlatforms(toRemove);
        game.addToPlatforms(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        game.setVersion(game.getVersion() + 1);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviews
     * @return Game
     */
    @Transactional
    public Game setReviews(Game game, Iterable<Long> reviews) {
        List<Review> items = getReviewService().findAll(reviews);
        Set<Review> currents = game.getReviews();
        Set<Review> toRemove = new HashSet<Review>();
        for (Iterator<Review> iterator = currents.iterator(); iterator.hasNext(); ) {
            Review nextReview = iterator.next();
            if (items.contains(nextReview)) {
                items.remove(nextReview);
            } else {
                toRemove.add(nextReview);
            }
        }
        game.removeFromReviews(toRemove);
        game.addToReviews(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        game.setVersion(game.getVersion() + 1);
        return getGameRepository().save(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     */
    @Transactional
    public void delete(Game game) {
        // Clear bidirectional many-to-one child relationship with DevStudio
        if (game.getDevstudio() != null) {
            game.getDevstudio().getGames().remove(game);
        }
        // Clear bidirectional many-to-one child relationship with GameType
        if (game.getGametype() != null) {
            game.getGametype().getGames().remove(game);
        }
        // Clear bidirectional one-to-many parent relationship with DLC
        for (DLC item : game.getDlcs()) {
            item.setGame(null);
        }
        // Clear bidirectional one-to-many parent relationship with GamePlat
        for (GamePlat item : game.getPlatforms()) {
            item.setGame(null);
        }
        // Clear bidirectional one-to-many parent relationship with Review
        for (Review item : game.getReviews()) {
            item.setGame(null);
        }
        getGameRepository().delete(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Game> save(Iterable<Game> entities) {
        return getGameRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Game> toDelete = getGameRepository().findAll(ids);
        getGameRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Game
     */
    @Transactional
    public Game save(Game entity) {
        return getGameRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Game
     */
    public Game findOne(Long id) {
        return getGameRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Game
     */
    public Game findOneForUpdate(Long id) {
        return getGameRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Game> findAll(Iterable<Long> ids) {
        return getGameRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Game> findAll() {
        return getGameRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getGameRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Game> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getGameRepository().findAll(globalSearch, pageable);
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
        return getGameRepository().findAllByIdsIn(ids, globalSearch, pageable);
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
        return getGameRepository().findByDevstudio(devstudio, globalSearch, pageable);
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
        return getGameRepository().findByGametype(gametype, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public long countByDevstudio(DevStudio devstudio) {
        return getGameRepository().countByDevstudio(devstudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @return Long
     */
    public long countByGametype(GameType gametype) {
        return getGameRepository().countByGametype(gametype);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Game> getEntityType() {
        return Game.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
