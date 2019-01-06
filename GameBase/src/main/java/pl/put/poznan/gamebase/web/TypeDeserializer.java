package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.TypeService;
import pl.put.poznan.gamebase.structures.Type;

/**
 * = TypeDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Type.class)
public class TypeDeserializer extends JsonObjectDeserializer<Type> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private TypeService typeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param typeService
     * @param conversionService
     */
    @Autowired
    public TypeDeserializer(@Lazy TypeService typeService, ConversionService conversionService) {
        this.typeService = typeService;
        this.conversionService = conversionService;
    }
}
