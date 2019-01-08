package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.DLC;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = DLCJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = DLC.class)
public abstract class DLCJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = GameDeserializer.class)
    private Game game;

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
}
