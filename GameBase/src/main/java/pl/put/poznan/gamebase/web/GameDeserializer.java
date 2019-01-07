package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GameService;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Game.class)
public class GameDeserializer extends JsonObjectDeserializer<Game> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameService gameService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gameService
     * @param conversionService
     */
    @Autowired
    public GameDeserializer(@Lazy GameService gameService, ConversionService conversionService) {
        this.gameService = gameService;
        this.conversionService = conversionService;
    }
}
