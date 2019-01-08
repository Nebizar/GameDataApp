package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.GamePlat;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = GamePlatService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = GamePlat.class)
public interface GamePlatService extends EntityResolver<GamePlat, Long>, ValidatorService<GamePlat> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GamePlat
     */
    public abstract GamePlat findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     */
    public abstract void delete(GamePlat gamePlat);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<GamePlat> save(Iterable<GamePlat> entities);

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
     * @return GamePlat
     */
    public abstract GamePlat save(GamePlat entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GamePlat
     */
    public abstract GamePlat findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<GamePlat> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<GamePlat> findAll();

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
    public abstract Page<GamePlat> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findByPlatform(Platform platform, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public abstract long countByGame(Game game);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @return Long
     */
    public abstract long countByPlatform(Platform platform);
}
