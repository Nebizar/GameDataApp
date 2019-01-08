package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.DevStudio;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = DevStudioRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = DevStudio.class)
@Transactional(readOnly = true)
public interface DevStudioRepository extends DetachableJpaRepository<DevStudio, Long>, DevStudioRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @return Long
     */
    public abstract long countByPublisher(Publisher publisher);
}
