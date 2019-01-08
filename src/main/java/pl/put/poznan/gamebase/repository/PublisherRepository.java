package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Publisher;
import org.springframework.transaction.annotation.Transactional;

/**
 * = PublisherRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Publisher.class)
@Transactional(readOnly = true)
public interface PublisherRepository extends DetachableJpaRepository<Publisher, Long>, PublisherRepositoryCustom {
}
