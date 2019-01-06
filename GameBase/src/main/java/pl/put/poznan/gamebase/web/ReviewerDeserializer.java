package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.ReviewerService;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewerDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Reviewer.class)
public class ReviewerDeserializer extends JsonObjectDeserializer<Reviewer> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewerService reviewerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reviewerService
     * @param conversionService
     */
    @Autowired
    public ReviewerDeserializer(@Lazy ReviewerService reviewerService, ConversionService conversionService) {
        this.reviewerService = reviewerService;
        this.conversionService = conversionService;
    }
}
