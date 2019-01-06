package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.DLC;

/**
 * = DLCRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = DLC.class)
public interface DLCRepository extends DetachableJpaRepository<DLC, Long>, DLCRepositoryCustom {
}
