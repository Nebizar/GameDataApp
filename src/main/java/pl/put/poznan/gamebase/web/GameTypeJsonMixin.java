package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.GameType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameTypeJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = GameType.class)
public abstract class GameTypeJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Game> games;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Game> getGames() {
        return games;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param games
     */
    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
