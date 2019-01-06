package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.DLC;

/**
 * = DLCService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = DLC.class)
public interface DLCService extends EntityResolver<DLC, Long>, ValidatorService<DLC> {
}
