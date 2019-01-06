package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DLCService;
import pl.put.poznan.gamebase.structures.DLC;

/**
 * = DLCDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = DLC.class)
public class DLCDeserializer extends JsonObjectDeserializer<DLC> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DLCService dLCService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param dLCService
     * @param conversionService
     */
    @Autowired
    public DLCDeserializer(@Lazy DLCService dLCService, ConversionService conversionService) {
        this.dLCService = dLCService;
        this.conversionService = conversionService;
    }
}
