package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.DevStudio;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = DevStudioService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = DevStudio.class)
public interface DevStudioService extends EntityResolver<DevStudio, Long>, ValidatorService<DevStudio> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DevStudio
     */
    public abstract DevStudio findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     */
    public abstract void delete(DevStudio devStudio);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<DevStudio> save(Iterable<DevStudio> entities);

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
     * @return DevStudio
     */
    public abstract DevStudio save(DevStudio entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DevStudio
     */
    public abstract DevStudio findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<DevStudio> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<DevStudio> findAll();

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
    public abstract Page<DevStudio> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DevStudio> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToAdd
     * @return DevStudio
     */
    public abstract DevStudio addToDevelopers(DevStudio devStudio, Iterable<Long> developersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToRemove
     * @return DevStudio
     */
    public abstract DevStudio removeFromDevelopers(DevStudio devStudio, Iterable<Long> developersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developers
     * @return DevStudio
     */
    public abstract DevStudio setDevelopers(DevStudio devStudio, Iterable<Long> developers);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param gamesToAdd
     * @return DevStudio
     */
    public abstract DevStudio addToGames(DevStudio devStudio, Iterable<Long> gamesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param gamesToRemove
     * @return DevStudio
     */
    public abstract DevStudio removeFromGames(DevStudio devStudio, Iterable<Long> gamesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param games
     * @return DevStudio
     */
    public abstract DevStudio setGames(DevStudio devStudio, Iterable<Long> games);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DevStudio> findByPublisher(Publisher publisher, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @return Long
     */
    public abstract long countByPublisher(Publisher publisher);
}
