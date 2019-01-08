package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.GamePlat;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = GamePlatRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = GamePlat.class)
@Transactional(readOnly = true)
public interface GamePlatRepository extends DetachableJpaRepository<GamePlat, Long>, GamePlatRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public abstract long countByGame(Game game);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @return Long
     */
    public abstract long countByPlatform(Platform platform);
}
