package pl.put.poznan.gamebase.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import pl.put.poznan.gamebase.structures.DevStudio;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = DevStudioRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = DevStudio.class)
public interface DevStudioRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DevStudio> findByPublisher(Publisher publisher, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DevStudio> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<DevStudio> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
