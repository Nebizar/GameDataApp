package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameTypeService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = GameType.class)
public interface GameTypeService extends EntityResolver<GameType, Long>, ValidatorService<GameType> {
}
