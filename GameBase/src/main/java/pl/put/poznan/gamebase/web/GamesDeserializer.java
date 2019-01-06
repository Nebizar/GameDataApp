package pl.put.poznan.gamebase.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import pl.put.poznan.gamebase.service.api.GamesService;
import pl.put.poznan.gamebase.structures.Games;

/**
 * = GamesDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Games.class)
public class GamesDeserializer extends JsonObjectDeserializer<Games> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamesService gamesService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gamesService
     * @param conversionService
     */
    @Autowired
    public GamesDeserializer(@Lazy GamesService gamesService, ConversionService conversionService) {
        this.gamesService = gamesService;
        this.conversionService = conversionService;
    }
}
