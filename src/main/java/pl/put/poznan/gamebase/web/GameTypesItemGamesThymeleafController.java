package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.GameType;
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
import org.joda.time.format.DateTimeFormat;
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
import pl.put.poznan.gamebase.service.api.GameTypeService;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameTypesItemGamesThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = GameType.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "games", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/gametypes/{gameType}/games", name = "GameTypesItemGamesThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class GameTypesItemGamesThymeleafController {

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
    private GameTypeService gameTypeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameService gameService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<GameTypesCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gameTypeService
     * @param gameService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public GameTypesItemGamesThymeleafController(GameTypeService gameTypeService, GameService gameService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setGameTypeService(gameTypeService);
        setGameService(gameService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(GameTypesCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GameTypeService
     */
    public GameTypeService getGameTypeService() {
        return gameTypeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameTypeService
     */
    public void setGameTypeService(GameTypeService gameTypeService) {
        this.gameTypeService = gameTypeService;
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
    public MethodLinkBuilderFactory<GameTypesCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<GameTypesCollectionThymeleafController> collectionLink) {
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
     * @return GameType
     */
    @ModelAttribute
    public GameType getGameType(@PathVariable("gameType") Long id, Locale locale, HttpMethod method) {
        GameType gameType = null;
        if (HttpMethod.PUT.equals(method)) {
            gameType = gameTypeService.findOneForUpdate(id);
        } else {
            gameType = gameTypeService.findOne(id);
        }
        if (gameType == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "GameType", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return gameType;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("rel_date_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
     * @param gametype
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Game>> datatables(@ModelAttribute GameType gametype, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Game> games = getGameService().findByGametype(gametype, search, pageable);
        long totalGamesCount = getGameService().countByGametype(gametype);
        ConvertedDatatablesData<Game> data = new ConvertedDatatablesData<Game>(games, totalGamesCount, draw, getConversionService(), datatablesColumns);
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
    public ResponseEntity<ConvertedDatatablesData<Game>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Game> games = getGameService().findAllByIdsIn(ids, search, pageable);
        long totalGamesCount = games.getTotalElements();
        ConvertedDatatablesData<Game> data = new ConvertedDatatablesData<Game>(games, totalGamesCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute GameType gameType, Model model) {
        populateForm(model);
        model.addAttribute("game", new Game());
        return new ModelAndView("gametypes/games/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param gamesToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromGames", value = "/{gamesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromGames(@ModelAttribute GameType gameType, @PathVariable("gamesToRemove") Long gamesToRemove) {
        getGameTypeService().removeFromGames(gameType, Collections.singleton(gamesToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param gamesToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromGamesBatch", value = "/batch/{gamesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromGamesBatch(@ModelAttribute GameType gameType, @PathVariable("gamesToRemove") Collection<Long> gamesToRemove) {
        getGameTypeService().removeFromGames(gameType, gamesToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameType
     * @param games
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute GameType gameType, @RequestParam(value = "gamesIds", required = false) List<Long> games, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (games != null) {
            for (Iterator<Long> iterator = games.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, gameType.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (games != null) {
                gameType.setGames(new HashSet<Game>(getGameService().findAll(games)));
            } else {
                gameType.setGames(new HashSet<Game>());
            }
            // Reset the version to prevent update
            gameType.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("gameType", gameType);
            model.addAttribute("concurrency", true);
            return new ModelAndView("gametypes/games/create");
        } else if (!Objects.equals(version, gameType.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("gameType", gameType);
            model.addAttribute("concurrency", false);
            return new ModelAndView("gametypes/games/create");
        }
        getGameTypeService().setGames(gameType, games);
        return new ModelAndView("redirect:" + getCollectionLink().to(GameTypesCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
