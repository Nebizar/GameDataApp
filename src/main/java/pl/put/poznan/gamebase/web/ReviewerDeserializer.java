package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.ReviewerService;
import pl.put.poznan.gamebase.structures.Reviewer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = ReviewerDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Reviewer.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewerService
     */
    public ReviewerService getReviewerService() {
        return reviewerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewerService
     */
    public void setReviewerService(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
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
     * @return Reviewer
     */
    public Reviewer deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Reviewer reviewer = reviewerService.findOne(id);
        if (reviewer == null) {
            throw new NotFoundException("Reviewer not found");
        }
        return reviewer;
    }
}
