package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import pl.put.poznan.gamebase.structures.Developer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DeveloperJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Developer.class)
public abstract class DeveloperJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = DevStudioDeserializer.class)
    private DevStudio devstudio;

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
}
