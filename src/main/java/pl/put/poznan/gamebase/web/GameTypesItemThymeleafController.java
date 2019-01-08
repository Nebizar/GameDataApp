package pl.put.poznan.gamebase.web;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameTypesItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = GameType.class, type = ControllerType.ITEM)
@RooThymeleaf
public class GameTypesItemThymeleafController implements ConcurrencyManager<GameType> {
}
