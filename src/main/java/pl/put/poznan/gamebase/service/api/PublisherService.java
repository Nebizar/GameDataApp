package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Publisher;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = PublisherService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Publisher.class)
public interface PublisherService extends EntityResolver<Publisher, Long>, ValidatorService<Publisher> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Publisher
     */
    public abstract Publisher findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     */
    public abstract void delete(Publisher publisher);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Publisher> save(Iterable<Publisher> entities);

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
     * @return Publisher
     */
    public abstract Publisher save(Publisher entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Publisher
     */
    public abstract Publisher findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Publisher> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Publisher> findAll();

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
    public abstract Page<Publisher> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Publisher> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToAdd
     * @return Publisher
     */
    public abstract Publisher addToDev_studios(Publisher publisher, Iterable<Long> dev_studiosToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToRemove
     * @return Publisher
     */
    public abstract Publisher removeFromDev_studios(Publisher publisher, Iterable<Long> dev_studiosToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studios
     * @return Publisher
     */
    public abstract Publisher setDev_studios(Publisher publisher, Iterable<Long> dev_studios);
}
