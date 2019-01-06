package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Publishers;

/**
 * = PublisherssCollectionThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Publishers.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class PublisherssCollectionThymeleafController {
}
