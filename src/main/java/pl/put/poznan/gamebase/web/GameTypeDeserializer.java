package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GameTypeService;
import pl.put.poznan.gamebase.structures.GameType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = GameTypeDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = GameType.class)
@JsonComponent
public class GameTypeDeserializer extends JsonObjectDeserializer<GameType> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameTypeService gameTypeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gameTypeService
     * @param conversionService
     */
    @Autowired
    public GameTypeDeserializer(@Lazy GameTypeService gameTypeService, ConversionService conversionService) {
        this.gameTypeService = gameTypeService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GameTypeService
     */
    public GameTypeService getGameTypeService() {
        return gameTypeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameTypeService
     */
    public void setGameTypeService(GameTypeService gameTypeService) {
        this.gameTypeService = gameTypeService;
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
     * @return GameType
     */
    public GameType deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        GameType gameType = gameTypeService.findOne(id);
        if (gameType == null) {
            throw new NotFoundException("GameType not found");
        }
        return gameType;
    }
}
