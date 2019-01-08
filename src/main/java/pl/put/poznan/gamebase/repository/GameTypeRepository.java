package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.GameType;
import org.springframework.transaction.annotation.Transactional;

/**
 * = GameTypeRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = GameType.class)
@Transactional(readOnly = true)
public interface GameTypeRepository extends DetachableJpaRepository<GameType, Long>, GameTypeRepositoryCustom {
}
