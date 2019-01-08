package pl.put.poznan.gamebase.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import pl.put.poznan.gamebase.structures.Game;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Game.class)
public interface GameRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findByGametype(GameType gametype, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Game> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
