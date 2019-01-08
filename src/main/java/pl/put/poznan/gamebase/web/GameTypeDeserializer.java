package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GameTypeService;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameTypeDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = GameType.class)
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
}
