package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Game.class)
public interface GameRepository extends DetachableJpaRepository<Game, Long>, GameRepositoryCustom {
}
