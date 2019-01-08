package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Review;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Review.class)
@Transactional(readOnly = true)
public interface ReviewRepository extends DetachableJpaRepository<Review, Long>, ReviewRepositoryCustom {

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
