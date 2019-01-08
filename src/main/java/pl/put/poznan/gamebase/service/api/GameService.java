package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Game.class)
public interface GameService extends EntityResolver<Game, Long>, ValidatorService<Game> {
}
