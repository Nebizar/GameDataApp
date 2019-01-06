package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.GamePlat;

/**
 * = GamePlatRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = GamePlat.class)
public interface GamePlatRepository extends DetachableJpaRepository<GamePlat, Long>, GamePlatRepositoryCustom {
}
