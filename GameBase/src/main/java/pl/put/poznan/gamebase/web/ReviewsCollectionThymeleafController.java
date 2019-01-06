package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewsCollectionThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Review.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class ReviewsCollectionThymeleafController {
}
