package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameTypeRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = GameType.class)
public interface GameTypeRepository extends DetachableJpaRepository<GameType, Long>, GameTypeRepositoryCustom {
}
