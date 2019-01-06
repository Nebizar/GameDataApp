package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Review.class)
public interface ReviewService extends EntityResolver<Review, Long>, ValidatorService<Review> {
}
