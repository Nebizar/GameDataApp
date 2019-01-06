package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import pl.put.poznan.gamebase.structures.GamePlat;

/**
 * = GamePlatDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = GamePlat.class)
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
}
