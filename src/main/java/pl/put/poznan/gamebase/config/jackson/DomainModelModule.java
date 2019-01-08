package pl.put.poznan.gamebase.config.jackson;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.jackson.JsonComponent;
import pl.put.poznan.gamebase.structures.DLC;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Developer;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.GameType;
import pl.put.poznan.gamebase.structures.Platform;
import pl.put.poznan.gamebase.structures.Publisher;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.structures.Reviewer;
import pl.put.poznan.gamebase.web.DLCJsonMixin;
import pl.put.poznan.gamebase.web.DevStudioJsonMixin;
import pl.put.poznan.gamebase.web.DeveloperJsonMixin;
import pl.put.poznan.gamebase.web.GameJsonMixin;
import pl.put.poznan.gamebase.web.GamePlatJsonMixin;
import pl.put.poznan.gamebase.web.GameTypeJsonMixin;
import pl.put.poznan.gamebase.web.PlatformJsonMixin;
import pl.put.poznan.gamebase.web.PublisherJsonMixin;
import pl.put.poznan.gamebase.web.ReviewJsonMixin;
import pl.put.poznan.gamebase.web.ReviewerJsonMixin;

/**
 * = DomainModelModule
 TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(DLC.class, DLCJsonMixin.class);
        setMixInAnnotation(DevStudio.class, DevStudioJsonMixin.class);
        setMixInAnnotation(Developer.class, DeveloperJsonMixin.class);
        setMixInAnnotation(Game.class, GameJsonMixin.class);
        setMixInAnnotation(GamePlat.class, GamePlatJsonMixin.class);
        setMixInAnnotation(GameType.class, GameTypeJsonMixin.class);
        setMixInAnnotation(Platform.class, PlatformJsonMixin.class);
        setMixInAnnotation(Publisher.class, PublisherJsonMixin.class);
        setMixInAnnotation(Review.class, ReviewJsonMixin.class);
        setMixInAnnotation(Reviewer.class, ReviewerJsonMixin.class);
    }
}
