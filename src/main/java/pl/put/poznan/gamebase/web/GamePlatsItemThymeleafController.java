package pl.put.poznan.gamebase.web;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.GamePlat;
import io.springlets.data.web.validation.GenericValidator;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import io.springlets.web.mvc.util.concurrency.ConcurrencyCallback;
import io.springlets.web.mvc.util.concurrency.ConcurrencyTemplate;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import pl.put.poznan.gamebase.service.api.GamePlatService;

/**
 * = GamePlatsItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = GamePlat.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/gameplats/{gamePlat}", name = "GamePlatsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class GamePlatsItemThymeleafController implements ConcurrencyManager<GamePlat> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatService gamePlatService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<GamePlat> concurrencyTemplate = new ConcurrencyTemplate<GamePlat>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<GamePlatsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<GamePlatsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gamePlatService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public GamePlatsItemThymeleafController(GamePlatService gamePlatService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setGamePlatService(gamePlatService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(GamePlatsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(GamePlatsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GamePlatService
     */
    public GamePlatService getGamePlatService() {
        return gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlatService
     */
    public void setGamePlatService(GamePlatService gamePlatService) {
        this.gamePlatService = gamePlatService;
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
    public MethodLinkBuilderFactory<GamePlatsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<GamePlatsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<GamePlatsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<GamePlatsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return GamePlat
     */
    @ModelAttribute
    public GamePlat getGamePlat(@PathVariable("gamePlat") Long id, Locale locale, HttpMethod method) {
        GamePlat gamePlat = null;
        if (HttpMethod.PUT.equals(method)) {
            gamePlat = gamePlatService.findOneForUpdate(id);
        } else {
            gamePlat = gamePlatService.findOne(id);
        }
        if (gamePlat == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "GamePlat", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return gamePlat;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute GamePlat gamePlat, Model model) {
        model.addAttribute("gamePlat", gamePlat);
        return new ModelAndView("gameplats/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute GamePlat gamePlat, Model model) {
        model.addAttribute("gamePlat", gamePlat);
        return new ModelAndView("gameplats/showInline :: inline-content");
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
     * @return ConcurrencyTemplate
     */
    public ConcurrencyTemplate<GamePlat> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "gamePlat";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "gameplats/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(GamePlat record) {
        return getGamePlatService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(GamePlat entity, Model model) {
        // Populate the form with all the necessary elements
        populateForm(model);
        // Add concurrency attribute to the model to show the concurrency form
        // in the current edit view
        model.addAttribute("concurrency", true);
        // Add the new version value to the model.
        model.addAttribute("newVersion", getLastVersion(entity));
        // Add the current pet values to maintain the values introduced by the user
        model.addAttribute(getModelName(), entity);
        // Return the edit view path
        return new org.springframework.web.servlet.ModelAndView(getEditViewPath(), model.asMap());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param binder
     */
    @InitBinder("gamePlat")
    public void initGamePlatBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(GamePlat.class, getGamePlatService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute GamePlat gamePlat, Model model) {
        populateForm(model);
        model.addAttribute("gamePlat", gamePlat);
        return new ModelAndView("gameplats/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute GamePlat gamePlat, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        GamePlat savedGamePlat = getConcurrencyTemplate().execute(gamePlat, model, new ConcurrencyCallback<GamePlat>() {

            @Override
            public GamePlat doInConcurrency(GamePlat gamePlat) throws Exception {
                return getGamePlatService().save(gamePlat);
            }
        });
        UriComponents showURI = getItemLink().to(GamePlatsItemThymeleafLinkFactory.SHOW).with("gamePlat", savedGamePlat.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute GamePlat gamePlat) {
        getGamePlatService().delete(gamePlat);
        return ResponseEntity.ok().build();
    }
}
