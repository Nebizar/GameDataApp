package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.DLC;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = DLCService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = DLC.class)
public interface DLCService extends EntityResolver<DLC, Long>, ValidatorService<DLC> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DLC
     */
    public abstract DLC findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param dLC
     */
    public abstract void delete(DLC dLC);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<DLC> save(Iterable<DLC> entities);

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
     * @return DLC
     */
    public abstract DLC save(DLC entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DLC
     */
    public abstract DLC findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<DLC> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<DLC> findAll();

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
    public abstract Page<DLC> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DLC> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DLC> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public abstract long countByGame(Game game);
}
