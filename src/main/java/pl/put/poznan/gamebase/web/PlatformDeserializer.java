package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.PlatformService;
import pl.put.poznan.gamebase.structures.Platform;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = PlatformDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Platform.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return PlatformService
     */
    public PlatformService getPlatformService() {
        return platformService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformService
     */
    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
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
     * @return Platform
     */
    public Platform deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Platform platform = platformService.findOne(id);
        if (platform == null) {
            throw new NotFoundException("Platform not found");
        }
        return platform;
    }
}
