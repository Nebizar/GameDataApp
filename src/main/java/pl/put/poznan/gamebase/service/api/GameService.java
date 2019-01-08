package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Game;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Game.class)
public interface GameService extends EntityResolver<Game, Long>, ValidatorService<Game> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Game
     */
    public abstract Game findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     */
    public abstract void delete(Game game);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Game> save(Iterable<Game> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Game
     */
    public abstract Game save(Game entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Game
     */
    public abstract Game findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Game> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Game> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcsToAdd
     * @return Game
     */
    public abstract Game addToDlcs(Game game, Iterable<Long> dlcsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcsToRemove
     * @return Game
     */
    public abstract Game removeFromDlcs(Game game, Iterable<Long> dlcsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param dlcs
     * @return Game
     */
    public abstract Game setDlcs(Game game, Iterable<Long> dlcs);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platformsToAdd
     * @return Game
     */
    public abstract Game addToPlatforms(Game game, Iterable<Long> platformsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platformsToRemove
     * @return Game
     */
    public abstract Game removeFromPlatforms(Game game, Iterable<Long> platformsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param platforms
     * @return Game
     */
    public abstract Game setPlatforms(Game game, Iterable<Long> platforms);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToAdd
     * @return Game
     */
    public abstract Game addToReviews(Game game, Iterable<Long> reviewsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToRemove
     * @return Game
     */
    public abstract Game removeFromReviews(Game game, Iterable<Long> reviewsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviews
     * @return Game
     */
    public abstract Game setReviews(Game game, Iterable<Long> reviews);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findByGametype(GameType gametype, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public abstract long countByDevstudio(DevStudio devstudio);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @return Long
     */
    public abstract long countByGametype(GameType gametype);
}
