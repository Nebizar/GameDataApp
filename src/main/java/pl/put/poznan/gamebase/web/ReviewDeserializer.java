package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Review;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = ReviewDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Review.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewService
     */
    public ReviewService getReviewService() {
        return reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewService
     */
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Review
     */
    public Review deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Review review = reviewService.findOne(id);
        if (review == null) {
            throw new NotFoundException("Review not found");
        }
        return review;
    }
}
