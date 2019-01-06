package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Games;

/**
 * = GamesRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Games.class)
public interface GamesRepository extends DetachableJpaRepository<Games, Long>, GamesRepositoryCustom {
}
