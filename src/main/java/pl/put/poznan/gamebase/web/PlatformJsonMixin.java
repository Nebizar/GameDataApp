package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Platform;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import pl.put.poznan.gamebase.structures.GamePlat;

/**
 * = PlatformJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Platform.class)
public abstract class PlatformJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<GamePlat> games;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<GamePlat> getGames() {
        return games;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param games
     */
    public void setGames(Set<GamePlat> games) {
        this.games = games;
    }
}
