package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Type;

/**
 * = TypesItemGamesThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Type.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "games", views = { "show" })
@RooThymeleaf
public class TypesItemGamesThymeleafController {
}
