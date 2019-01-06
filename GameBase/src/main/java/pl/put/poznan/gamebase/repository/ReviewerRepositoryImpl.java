package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewerRepositoryImpl
 *
 * Implementation of ReviewerRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = ReviewerRepositoryCustom.class)
public class ReviewerRepositoryImpl extends QueryDslRepositorySupportExt<Reviewer> implements ReviewerRepositoryCustom{

    /**
     * Default constructor
     */
    ReviewerRepositoryImpl() {
        super(Reviewer.class);
    }
}