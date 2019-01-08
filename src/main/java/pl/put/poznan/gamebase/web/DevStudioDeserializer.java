package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DevStudioService;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DevStudioDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = DevStudio.class)
public class DevStudioDeserializer extends JsonObjectDeserializer<DevStudio> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DevStudioService devStudioService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param devStudioService
     * @param conversionService
     */
    @Autowired
    public DevStudioDeserializer(@Lazy DevStudioService devStudioService, ConversionService conversionService) {
        this.devStudioService = devStudioService;
        this.conversionService = conversionService;
    }
}
