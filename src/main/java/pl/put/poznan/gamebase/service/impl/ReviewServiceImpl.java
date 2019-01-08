package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.ReviewService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.ReviewRepository;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = ReviewService.class)
@Service
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewRepository reviewRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reviewRepository
     */
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        setReviewRepository(reviewRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewRepository
     */
    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewRepository
     */
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param review
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Review review) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param review
     */
    @Transactional
    public void delete(Review review) {
        // Clear bidirectional many-to-one child relationship with Game
        if (review.getGame() != null) {
            review.getGame().getReviews().remove(review);
        }
        // Clear bidirectional many-to-one child relationship with Reviewer
        if (review.getReviewer() != null) {
            review.getReviewer().getReviews().remove(review);
        }
        getReviewRepository().delete(review);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Review> save(Iterable<Review> entities) {
        return getReviewRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Review> toDelete = getReviewRepository().findAll(ids);
        getReviewRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Review
     */
    @Transactional
    public Review save(Review entity) {
        return getReviewRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Review
     */
    public Review findOne(Long id) {
        return getReviewRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Review
     */
    public Review findOneForUpdate(Long id) {
        return getReviewRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Review> findAll(Iterable<Long> ids) {
        return getReviewRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Review> findAll() {
        return getReviewRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getReviewRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Review> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getReviewRepository().findAll(globalSearch, pageable);
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
        return getReviewRepository().findAllByIdsIn(ids, globalSearch, pageable);
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
        return getReviewRepository().findByGame(game, globalSearch, pageable);
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
        return getReviewRepository().findByReviewer(reviewer, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public long countByGame(Game game) {
        return getReviewRepository().countByGame(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @return Long
     */
    public long countByReviewer(Reviewer reviewer) {
        return getReviewRepository().countByReviewer(reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Review> getEntityType() {
        return Review.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
