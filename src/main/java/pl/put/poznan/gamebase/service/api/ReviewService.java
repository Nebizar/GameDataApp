package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Review;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Review.class)
public interface ReviewService extends EntityResolver<Review, Long>, ValidatorService<Review> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Review
     */
    public abstract Review findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param review
     */
    public abstract void delete(Review review);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Review> save(Iterable<Review> entities);

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
     * @return Review
     */
    public abstract Review save(Review entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Review
     */
    public abstract Review findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Review> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Review> findAll();

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
    public abstract Page<Review> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> findByReviewer(Reviewer reviewer, GlobalSearch globalSearch, Pageable pageable);

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
     * @param reviewer
     * @return Long
     */
    public abstract long countByReviewer(Reviewer reviewer);
}
