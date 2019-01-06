package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Type;

/**
 * = TypeRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Type.class)
public interface TypeRepository extends DetachableJpaRepository<Type, Long>, TypeRepositoryCustom {
}
