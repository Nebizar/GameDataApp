package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Game;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.gamebase.service.api.GameService;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = GamesItemReviewsThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Game.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "reviews", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/games/{game}/reviews", name = "GamesItemReviewsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class GamesItemReviewsThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameService gameService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewService reviewService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<GamesCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gameService
     * @param reviewService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public GamesItemReviewsThymeleafController(GameService gameService, ReviewService reviewService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setGameService(gameService);
        setReviewService(reviewService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(GamesCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GameService
     */
    public GameService getGameService() {
        return gameService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameService
     */
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewService
     */
    public ReviewService getReviewService() {
        return reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewService
     */
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<GamesCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<GamesCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Game
     */
    @ModelAttribute
    public Game getGame(@PathVariable("game") Long id, Locale locale, HttpMethod method) {
        Game game = null;
        if (HttpMethod.PUT.equals(method)) {
            game = gameService.findOneForUpdate(id);
        } else {
            game = gameService.findOne(id);
        }
        if (game == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Game", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return game;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Review>> datatables(@ModelAttribute Game game, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Review> reviews = getReviewService().findByGame(game, search, pageable);
        long totalReviewsCount = getReviewService().countByGame(game);
        ConvertedDatatablesData<Review> data = new ConvertedDatatablesData<Review>(reviews, totalReviewsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatablesByIdsIn", produces = Datatables.MEDIA_TYPE, value = "/dtByIdsIn")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Review>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Review> reviews = getReviewService().findAllByIdsIn(ids, search, pageable);
        long totalReviewsCount = reviews.getTotalElements();
        ConvertedDatatablesData<Review> data = new ConvertedDatatablesData<Review>(reviews, totalReviewsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Game game, Model model) {
        populateForm(model);
        model.addAttribute("review", new Review());
        return new ModelAndView("games/reviews/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromReviews", value = "/{reviewsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromReviews(@ModelAttribute Game game, @PathVariable("reviewsToRemove") Long reviewsToRemove) {
        getGameService().removeFromReviews(game, Collections.singleton(reviewsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviewsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromReviewsBatch", value = "/batch/{reviewsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromReviewsBatch(@ModelAttribute Game game, @PathVariable("reviewsToRemove") Collection<Long> reviewsToRemove) {
        getGameService().removeFromReviews(game, reviewsToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param reviews
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Game game, @RequestParam(value = "reviewsIds", required = false) List<Long> reviews, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (reviews != null) {
            for (Iterator<Long> iterator = reviews.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, game.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (reviews != null) {
                game.setReviews(new HashSet<Review>(getReviewService().findAll(reviews)));
            } else {
                game.setReviews(new HashSet<Review>());
            }
            // Reset the version to prevent update
            game.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("game", game);
            model.addAttribute("concurrency", true);
            return new ModelAndView("games/reviews/create");
        } else if (!Objects.equals(version, game.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("game", game);
            model.addAttribute("concurrency", false);
            return new ModelAndView("games/reviews/create");
        }
        getGameService().setReviews(game, reviews);
        return new ModelAndView("redirect:" + getCollectionLink().to(GamesCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
