package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Publishers;

/**
 * = PublishersService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Publishers.class)
public interface PublishersService extends EntityResolver<Publishers, Long>, ValidatorService<Publishers> {
}
