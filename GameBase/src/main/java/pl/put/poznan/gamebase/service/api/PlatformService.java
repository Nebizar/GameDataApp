package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = PlatformService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Platform.class)
public interface PlatformService extends EntityResolver<Platform, Long>, ValidatorService<Platform> {
}
