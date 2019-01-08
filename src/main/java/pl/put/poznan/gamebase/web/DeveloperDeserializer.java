package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DeveloperService;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DeveloperDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Developer.class)
public class DeveloperDeserializer extends JsonObjectDeserializer<Developer> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DeveloperService developerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param developerService
     * @param conversionService
     */
    @Autowired
    public DeveloperDeserializer(@Lazy DeveloperService developerService, ConversionService conversionService) {
        this.developerService = developerService;
        this.conversionService = conversionService;
    }
}
