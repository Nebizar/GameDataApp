package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;
import pl.put.poznan.gamebase.structures.DLC;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.GameType;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = GameJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Game.class)
public abstract class GameJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = DevStudioDeserializer.class)
    private DevStudio devstudio;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Review> reviews;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<DLC> dlcs;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = GameTypeDeserializer.class)
    private GameType gametype;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<GamePlat> platforms;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<DLC> getDlcs() {
        return dlcs;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dlcs
     */
    public void setDlcs(Set<DLC> dlcs) {
        this.dlcs = dlcs;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<GamePlat> getPlatforms() {
        return platforms;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platforms
     */
    public void setPlatforms(Set<GamePlat> platforms) {
        this.platforms = platforms;
    }

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

    /**
     * TODO Auto-generated method documentation
     *
     * @return DevStudio
     */
    public DevStudio getDevstudio() {
        return devstudio;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     */
    public void setDevstudio(DevStudio devstudio) {
        this.devstudio = devstudio;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GameType
     */
    public GameType getGametype() {
        return gametype;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gametype
     */
    public void setGametype(GameType gametype) {
        this.gametype = gametype;
    }
}
