package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import pl.put.poznan.gamebase.structures.Reviewer;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ReviewerRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Reviewer.class)
@Transactional(readOnly = true)
public interface ReviewerRepository extends DetachableJpaRepository<Reviewer, Long>, ReviewerRepositoryCustom {
}
