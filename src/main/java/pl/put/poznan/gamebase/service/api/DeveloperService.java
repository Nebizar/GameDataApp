package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Developer;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DeveloperService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Developer.class)
public interface DeveloperService extends EntityResolver<Developer, Long>, ValidatorService<Developer> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Developer
     */
    public abstract Developer findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param developer
     */
    public abstract void delete(Developer developer);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Developer> save(Iterable<Developer> entities);

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
     * @return Developer
     */
    public abstract Developer save(Developer entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Developer
     */
    public abstract Developer findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Developer> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Developer> findAll();

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
    public abstract Page<Developer> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Developer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Developer> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public abstract long countByDevstudio(DevStudio devstudio);
}
