package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.DevStudio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;
import pl.put.poznan.gamebase.structures.Developer;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = DevStudioJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = DevStudio.class)
public abstract class DevStudioJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Developer> developers;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Game> games;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = PublisherDeserializer.class)
    private Publisher publisher;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Developer> getDevelopers() {
        return developers;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developers
     */
    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

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

    /**
     * TODO Auto-generated method documentation
     *
     * @return Publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
