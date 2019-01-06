package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Developers;

/**
 * = DevelopersRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Developers.class)
public interface DevelopersRepository extends DetachableJpaRepository<Developers, Long>, DevelopersRepositoryCustom {
}
