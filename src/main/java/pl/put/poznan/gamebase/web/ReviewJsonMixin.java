package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Review;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Reviewer;

/**
 * = ReviewJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Review.class)
public abstract class ReviewJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = GameDeserializer.class)
    private Game game;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ReviewerDeserializer.class)
    private Reviewer reviewer;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Game
     */
    public Game getGame() {
        return game;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Reviewer
     */
    public Reviewer getReviewer() {
        return reviewer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     */
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
}
