package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Developers;

/**
 * = DevelopersService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Developers.class)
public interface DevelopersService extends EntityResolver<Developers, Long>, ValidatorService<Developers> {
}
