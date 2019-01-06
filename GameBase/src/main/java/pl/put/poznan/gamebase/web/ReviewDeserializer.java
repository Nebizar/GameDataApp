package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Review.class)
public class ReviewDeserializer extends JsonObjectDeserializer<Review> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewService reviewService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reviewService
     * @param conversionService
     */
    @Autowired
    public ReviewDeserializer(@Lazy ReviewService reviewService, ConversionService conversionService) {
        this.reviewService = reviewService;
        this.conversionService = conversionService;
    }
}
