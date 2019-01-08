package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = PublisherRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Publisher.class)
public interface PublisherRepository extends DetachableJpaRepository<Publisher, Long>, PublisherRepositoryCustom {
}
