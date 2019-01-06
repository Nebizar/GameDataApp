package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Type;

/**
 * = TypeService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Type.class)
public interface TypeService extends EntityResolver<Type, Long>, ValidatorService<Type> {
}
