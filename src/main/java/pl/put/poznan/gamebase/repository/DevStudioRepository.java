package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DevStudioRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = DevStudio.class)
public interface DevStudioRepository extends DetachableJpaRepository<DevStudio, Long>, DevStudioRepositoryCustom {
}
