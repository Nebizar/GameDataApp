package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.PublisherService;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = PublisherDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Publisher.class)
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
}
