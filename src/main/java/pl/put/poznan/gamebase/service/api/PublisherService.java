package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = PublisherService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Publisher.class)
public interface PublisherService extends EntityResolver<Publisher, Long>, ValidatorService<Publisher> {
}
