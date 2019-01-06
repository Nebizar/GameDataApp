// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.core.convert.ConversionService;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.web.ReviewDeserializer;

privileged aspect ReviewDeserializer_Roo_EntityDeserializer {
    
    declare @type: ReviewDeserializer: @JsonComponent;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ReviewService
     */
    public ReviewService ReviewDeserializer.getReviewService() {
        return reviewService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewService
     */
    public void ReviewDeserializer.setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ConversionService
     */
    public ConversionService ReviewDeserializer.getConversionService() {
        return conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param conversionService
     */
    public void ReviewDeserializer.setConversionService(ConversionService conversionService) {
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
     * @throws IOException
     */
    public Review ReviewDeserializer.deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Review review = reviewService.findOne(id);
        if (review == null) {
            throw new NotFoundException("Review not found");
        }
        return review;
    }
    
}
