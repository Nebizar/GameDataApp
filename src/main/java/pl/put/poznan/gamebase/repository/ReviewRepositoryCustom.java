package pl.put.poznan.gamebase.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import pl.put.poznan.gamebase.structures.Review;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Review.class)
public interface ReviewRepositoryCustom {

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
}
