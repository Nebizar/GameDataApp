package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DeveloperService;
import pl.put.poznan.gamebase.structures.Developer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DeveloperDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Developer.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return DeveloperService
     */
    public DeveloperService getDeveloperService() {
        return developerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developerService
     */
    public void setDeveloperService(DeveloperService developerService) {
        this.developerService = developerService;
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
     * @return Developer
     */
    public Developer deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Developer developer = developerService.findOne(id);
        if (developer == null) {
            throw new NotFoundException("Developer not found");
        }
        return developer;
    }
}
