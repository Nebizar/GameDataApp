package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Reviewer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewerJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Reviewer.class)
public abstract class ReviewerJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Review> reviews;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Review> getReviews() {
        return reviews;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviews
     */
    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
