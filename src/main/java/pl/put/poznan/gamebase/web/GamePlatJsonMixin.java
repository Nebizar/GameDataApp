package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.GamePlat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = GamePlatJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = GamePlat.class)
public abstract class GamePlatJsonMixin {

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
    @JsonDeserialize(using = PlatformDeserializer.class)
    private Platform platform;

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
     * @return Platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
