package pl.put.poznan.gamebase.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DevStudioService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = DevStudio.class)
public interface DevStudioService extends EntityResolver<DevStudio, Long>, ValidatorService<DevStudio> {
}