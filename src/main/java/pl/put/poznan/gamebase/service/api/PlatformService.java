package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Platform;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = PlatformService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Platform.class)
public interface PlatformService extends EntityResolver<Platform, Long>, ValidatorService<Platform> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Platform
     */
    public abstract Platform findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     */
    public abstract void delete(Platform platform);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Platform> save(Iterable<Platform> entities);

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
     * @return Platform
     */
    public abstract Platform save(Platform entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Platform
     */
    public abstract Platform findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Platform> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Platform> findAll();

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
    public abstract Page<Platform> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Platform> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToAdd
     * @return Platform
     */
    public abstract Platform addToGames(Platform platform, Iterable<Long> gamesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToRemove
     * @return Platform
     */
    public abstract Platform removeFromGames(Platform platform, Iterable<Long> gamesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param games
     * @return Platform
     */
    public abstract Platform setGames(Platform platform, Iterable<Long> games);
}
