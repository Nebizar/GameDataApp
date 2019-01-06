package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.PlatformService;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = PlatformDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Platform.class)
public class PlatformDeserializer extends JsonObjectDeserializer<Platform> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PlatformService platformService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param platformService
     * @param conversionService
     */
    @Autowired
    public PlatformDeserializer(@Lazy PlatformService platformService, ConversionService conversionService) {
        this.platformService = platformService;
        this.conversionService = conversionService;
    }
}
