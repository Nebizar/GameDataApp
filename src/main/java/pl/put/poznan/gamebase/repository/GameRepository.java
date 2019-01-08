package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Game;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Game.class)
@Transactional(readOnly = true)
public interface GameRepository extends DetachableJpaRepository<Game, Long>, GameRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public abstract long countByDevstudio(DevStudio devstudio);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @return Long
     */
    public abstract long countByGametype(GameType gametype);
}
