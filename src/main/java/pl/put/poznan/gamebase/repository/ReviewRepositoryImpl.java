package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Review;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.QReview;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ReviewRepositoryCustom.class)
@Transactional(readOnly = true)
public class ReviewRepositoryImpl extends QueryDslRepositorySupportExt<Review> implements ReviewRepositoryCustom {

    /**
     * Default constructor
     */
    ReviewRepositoryImpl() {
        super(Review.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REVIEWER = "reviewer";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GAME = "game";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String USER___SCORE = "user_score";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GAMEPLAY = "gameplay";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GRAPHICS = "graphics";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String AUDIO = "audio";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CRIT___SCORE = "crit_score";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Review> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QReview review = QReview.review;
        JPQLQuery<Review> query = from(review);
        Path<?>[] paths = new Path<?>[] { review.reviewer, review.user_score, review.crit_score, review.gameplay, review.graphics, review.audio, review.game };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(REVIEWER, review.reviewer).map(USER___SCORE, review.user_score).map(CRIT___SCORE, review.crit_score).map(GAMEPLAY, review.gameplay).map(GRAPHICS, review.graphics).map(AUDIO, review.audio).map(GAME, review.game);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, review);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Review> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QReview review = QReview.review;
        JPQLQuery<Review> query = from(review);
        Path<?>[] paths = new Path<?>[] { review.reviewer, review.user_score, review.crit_score, review.gameplay, review.graphics, review.audio, review.game };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(review.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(REVIEWER, review.reviewer).map(USER___SCORE, review.user_score).map(CRIT___SCORE, review.crit_score).map(GAMEPLAY, review.gameplay).map(GRAPHICS, review.graphics).map(AUDIO, review.audio).map(GAME, review.game);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, review);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Review> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable) {
        QReview review = QReview.review;
        JPQLQuery<Review> query = from(review);
        Assert.notNull(game, "game is required");
        query.where(review.game.eq(game));
        Path<?>[] paths = new Path<?>[] { review.reviewer, review.user_score, review.crit_score, review.gameplay, review.graphics, review.audio, review.game };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(REVIEWER, review.reviewer).map(USER___SCORE, review.user_score).map(CRIT___SCORE, review.crit_score).map(GAMEPLAY, review.gameplay).map(GRAPHICS, review.graphics).map(AUDIO, review.audio).map(GAME, review.game);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, review);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Review> findByReviewer(Reviewer reviewer, GlobalSearch globalSearch, Pageable pageable) {
        QReview review = QReview.review;
        JPQLQuery<Review> query = from(review);
        Assert.notNull(reviewer, "reviewer is required");
        query.where(review.reviewer.eq(reviewer));
        Path<?>[] paths = new Path<?>[] { review.reviewer, review.user_score, review.crit_score, review.gameplay, review.graphics, review.audio, review.game };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(REVIEWER, review.reviewer).map(USER___SCORE, review.user_score).map(CRIT___SCORE, review.crit_score).map(GAMEPLAY, review.gameplay).map(GRAPHICS, review.graphics).map(AUDIO, review.audio).map(GAME, review.game);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, review);
    }
}
