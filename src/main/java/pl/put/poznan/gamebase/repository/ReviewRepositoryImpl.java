package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewRepositoryImpl
 *
 * Implementation of ReviewRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = ReviewRepositoryCustom.class)
public class ReviewRepositoryImpl extends QueryDslRepositorySupportExt<Review> implements ReviewRepositoryCustom{

    /**
     * Default constructor
     */
    ReviewRepositoryImpl() {
        super(Review.class);
    }
}