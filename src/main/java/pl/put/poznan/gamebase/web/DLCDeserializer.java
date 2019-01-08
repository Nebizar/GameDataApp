package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.DLCService;
import pl.put.poznan.gamebase.structures.DLC;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DLCDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = DLC.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return DLCService
     */
    public DLCService getDLCService() {
        return dLCService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dLCService
     */
    public void setDLCService(DLCService dLCService) {
        this.dLCService = dLCService;
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
     * @return DLC
     */
    public DLC deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        DLC dLC = dLCService.findOne(id);
        if (dLC == null) {
            throw new NotFoundException("DLC not found");
        }
        return dLC;
    }
}
