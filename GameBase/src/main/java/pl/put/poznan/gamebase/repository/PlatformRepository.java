package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = PlatformRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Platform.class)
public interface PlatformRepository extends DetachableJpaRepository<Platform, Long>, PlatformRepositoryCustom {
}
