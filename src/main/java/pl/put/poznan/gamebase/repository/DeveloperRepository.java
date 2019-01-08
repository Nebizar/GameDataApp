package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Developer;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DeveloperRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Developer.class)
@Transactional(readOnly = true)
public interface DeveloperRepository extends DetachableJpaRepository<Developer, Long>, DeveloperRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public abstract long countByDevstudio(DevStudio devstudio);
}
