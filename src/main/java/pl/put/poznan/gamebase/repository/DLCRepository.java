package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.DLC;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = DLCRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = DLC.class)
@Transactional(readOnly = true)
public interface DLCRepository extends DetachableJpaRepository<DLC, Long>, DLCRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public abstract long countByGame(Game game);
}
