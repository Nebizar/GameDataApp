package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.ReviewerService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.ReviewerRepository;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewerServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = ReviewerService.class)
@Service
@Transactional(readOnly = true)
public class ReviewerServiceImpl implements ReviewerService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewerRepository reviewerRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewService reviewService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reviewerRepository
     * @param reviewService
     */
    @Autowired
    public ReviewerServiceImpl(ReviewerRepository reviewerRepository, @Lazy ReviewService reviewService) {
        setReviewerRepository(reviewerRepository);
        setReviewService(reviewService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewerRepository
     */
    public ReviewerRepository getReviewerRepository() {
        return reviewerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewerRepository
     */
    public void setReviewerRepository(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewService
     */
    public ReviewService getReviewService() {
        return reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewService
     */
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Reviewer reviewer) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToAdd
     * @return Reviewer
     */
    @Transactional
    public Reviewer addToReviews(Reviewer reviewer, Iterable<Long> reviewsToAdd) {
        List<Review> reviews = getReviewService().findAll(reviewsToAdd);
        reviewer.addToReviews(reviews);
        return getReviewerRepository().save(reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToRemove
     * @return Reviewer
     */
    @Transactional
    public Reviewer removeFromReviews(Reviewer reviewer, Iterable<Long> reviewsToRemove) {
        List<Review> reviews = getReviewService().findAll(reviewsToRemove);
        reviewer.removeFromReviews(reviews);
        return getReviewerRepository().save(reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviews
     * @return Reviewer
     */
    @Transactional
    public Reviewer setReviews(Reviewer reviewer, Iterable<Long> reviews) {
        List<Review> items = getReviewService().findAll(reviews);
        Set<Review> currents = reviewer.getReviews();
        Set<Review> toRemove = new HashSet<Review>();
        for (Iterator<Review> iterator = currents.iterator(); iterator.hasNext(); ) {
            Review nextReview = iterator.next();
            if (items.contains(nextReview)) {
                items.remove(nextReview);
            } else {
                toRemove.add(nextReview);
            }
        }
        reviewer.removeFromReviews(toRemove);
        reviewer.addToReviews(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        reviewer.setVersion(reviewer.getVersion() + 1);
        return getReviewerRepository().save(reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     */
    @Transactional
    public void delete(Reviewer reviewer) {
        // Clear bidirectional one-to-many parent relationship with Review
        for (Review item : reviewer.getReviews()) {
            item.setReviewer(null);
        }
        getReviewerRepository().delete(reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Reviewer> save(Iterable<Reviewer> entities) {
        return getReviewerRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Reviewer> toDelete = getReviewerRepository().findAll(ids);
        getReviewerRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Reviewer
     */
    @Transactional
    public Reviewer save(Reviewer entity) {
        return getReviewerRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Reviewer
     */
    public Reviewer findOne(Long id) {
        return getReviewerRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Reviewer
     */
    public Reviewer findOneForUpdate(Long id) {
        return getReviewerRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Reviewer> findAll(Iterable<Long> ids) {
        return getReviewerRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Reviewer> findAll() {
        return getReviewerRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getReviewerRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Reviewer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getReviewerRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Reviewer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getReviewerRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Reviewer> getEntityType() {
        return Reviewer.class;
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
