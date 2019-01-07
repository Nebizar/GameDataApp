package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DeveloperRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Developer.class)
public interface DeveloperRepository extends DetachableJpaRepository<Developer, Long>, DeveloperRepositoryCustom {
}
