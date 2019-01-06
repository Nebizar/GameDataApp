package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewerService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Reviewer.class)
public interface ReviewerService extends EntityResolver<Reviewer, Long>, ValidatorService<Reviewer> {
}
