package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Reviewer;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ReviewerService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Reviewer.class)
public interface ReviewerService extends EntityResolver<Reviewer, Long>, ValidatorService<Reviewer> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Reviewer
     */
    public abstract Reviewer findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     */
    public abstract void delete(Reviewer reviewer);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Reviewer> save(Iterable<Reviewer> entities);

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
     * @return Reviewer
     */
    public abstract Reviewer save(Reviewer entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Reviewer
     */
    public abstract Reviewer findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Reviewer> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Reviewer> findAll();

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
    public abstract Page<Reviewer> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Reviewer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToAdd
     * @return Reviewer
     */
    public abstract Reviewer addToReviews(Reviewer reviewer, Iterable<Long> reviewsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToRemove
     * @return Reviewer
     */
    public abstract Reviewer removeFromReviews(Reviewer reviewer, Iterable<Long> reviewsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviews
     * @return Reviewer
     */
    public abstract Reviewer setReviews(Reviewer reviewer, Iterable<Long> reviews);
}
