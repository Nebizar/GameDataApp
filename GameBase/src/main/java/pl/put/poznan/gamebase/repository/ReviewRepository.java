package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Review.class)
public interface ReviewRepository extends DetachableJpaRepository<Review, Long>, ReviewRepositoryCustom {
}
