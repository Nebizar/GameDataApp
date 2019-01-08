package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.PublisherService;
import pl.put.poznan.gamebase.structures.Publisher;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = PublisherDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Publisher.class)
@JsonComponent
public class PublisherDeserializer extends JsonObjectDeserializer<Publisher> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PublisherService publisherService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param publisherService
     * @param conversionService
     */
    @Autowired
    public PublisherDeserializer(@Lazy PublisherService publisherService, ConversionService conversionService) {
        this.publisherService = publisherService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PublisherService
     */
    public PublisherService getPublisherService() {
        return publisherService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisherService
     */
    public void setPublisherService(PublisherService publisherService) {
        this.publisherService = publisherService;
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
     * @return Publisher
     */
    public Publisher deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Publisher publisher = publisherService.findOne(id);
        if (publisher == null) {
            throw new NotFoundException("Publisher not found");
        }
        return publisher;
    }
}
