package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.PublishersService;
import pl.put.poznan.gamebase.structures.Publishers;

/**
 * = PublishersDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Publishers.class)
public class PublishersDeserializer extends JsonObjectDeserializer<Publishers> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PublishersService publishersService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param publishersService
     * @param conversionService
     */
    @Autowired
    public PublishersDeserializer(@Lazy PublishersService publishersService, ConversionService conversionService) {
        this.publishersService = publishersService;
        this.conversionService = conversionService;
    }
}
