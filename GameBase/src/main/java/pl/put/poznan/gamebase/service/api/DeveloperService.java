package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DeveloperService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Developer.class)
public interface DeveloperService extends EntityResolver<Developer, Long>, ValidatorService<Developer> {
}
