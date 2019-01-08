package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import pl.put.poznan.gamebase.structures.GamePlat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = GamePlatDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = GamePlat.class)
@JsonComponent
public class GamePlatDeserializer extends JsonObjectDeserializer<GamePlat> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatService gamePlatService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gamePlatService
     * @param conversionService
     */
    @Autowired
    public GamePlatDeserializer(@Lazy GamePlatService gamePlatService, ConversionService conversionService) {
        this.gamePlatService = gamePlatService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GamePlatService
     */
    public GamePlatService getGamePlatService() {
        return gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlatService
     */
    public void setGamePlatService(GamePlatService gamePlatService) {
        this.gamePlatService = gamePlatService;
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
     * @return GamePlat
     */
    public GamePlat deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        GamePlat gamePlat = gamePlatService.findOne(id);
        if (gamePlat == null) {
            throw new NotFoundException("GamePlat not found");
        }
        return gamePlat;
    }
}
