package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = PublisherJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Publisher.class)
public abstract class PublisherJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<DevStudio> dev_studios;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<DevStudio> getDev_studios() {
        return dev_studios;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dev_studios
     */
    public void setDev_studios(Set<DevStudio> dev_studios) {
        this.dev_studios = dev_studios;
    }
}
