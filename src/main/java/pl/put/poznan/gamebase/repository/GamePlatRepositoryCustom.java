package pl.put.poznan.gamebase.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import pl.put.poznan.gamebase.structures.GamePlat;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = GamePlatRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = GamePlat.class)
public interface GamePlatRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findByPlatform(Platform platform, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<GamePlat> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
