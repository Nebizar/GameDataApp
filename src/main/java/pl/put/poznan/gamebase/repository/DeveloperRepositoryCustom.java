package pl.put.poznan.gamebase.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import pl.put.poznan.gamebase.structures.Developer;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DeveloperRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Developer.class)
public interface DeveloperRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Developer> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Developer> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Developer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
