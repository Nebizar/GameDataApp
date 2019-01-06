package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Publishers;

/**
 * = PublishersRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Publishers.class)
public interface PublishersRepository extends DetachableJpaRepository<Publishers, Long>, PublishersRepositoryCustom {
}
