package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.GameType;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = GameTypeService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = GameType.class)
public interface GameTypeService extends EntityResolver<GameType, Long>, ValidatorService<GameType> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GameType
     */
    public abstract GameType findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     */
    public abstract void delete(GameType gameType);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<GameType> save(Iterable<GameType> entities);

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
     * @return GameType
     */
    public abstract GameType save(GameType entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GameType
     */
    public abstract GameType findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<GameType> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<GameType> findAll();

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
    public abstract Page<GameType> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GameType> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param gamesToAdd
     * @return GameType
     */
    public abstract GameType addToGames(GameType gameType, Iterable<Long> gamesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param gamesToRemove
     * @return GameType
     */
    public abstract GameType removeFromGames(GameType gameType, Iterable<Long> gamesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param games
     * @return GameType
     */
    public abstract GameType setGames(GameType gameType, Iterable<Long> games);
}
