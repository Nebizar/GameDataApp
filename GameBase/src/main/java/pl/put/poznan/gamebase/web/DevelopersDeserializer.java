package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DevelopersService;
import pl.put.poznan.gamebase.structures.Developers;

/**
 * = DevelopersDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Developers.class)
public class DevelopersDeserializer extends JsonObjectDeserializer<Developers> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DevelopersService developersService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param developersService
     * @param conversionService
     */
    @Autowired
    public DevelopersDeserializer(@Lazy DevelopersService developersService, ConversionService conversionService) {
        this.developersService = developersService;
        this.conversionService = conversionService;
    }
}
