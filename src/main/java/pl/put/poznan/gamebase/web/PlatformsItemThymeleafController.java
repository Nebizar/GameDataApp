package pl.put.poznan.gamebase.web;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Platform;
import io.springlets.data.web.validation.GenericValidator;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import io.springlets.web.mvc.util.concurrency.ConcurrencyCallback;
import io.springlets.web.mvc.util.concurrency.ConcurrencyTemplate;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
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
import pl.put.poznan.gamebase.service.api.PlatformService;

/**
 * = PlatformsItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Platform.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/platforms/{platform}", name = "PlatformsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class PlatformsItemThymeleafController implements ConcurrencyManager<Platform> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PlatformService platformService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<Platform> concurrencyTemplate = new ConcurrencyTemplate<Platform>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PlatformsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> collectionLink;

    private EntityManager em;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param platformService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PlatformsItemThymeleafController(PlatformService platformService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder, EntityManager em) {
        setPlatformService(platformService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(PlatformsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(PlatformsCollectionThymeleafController.class));
        this.em = em;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PlatformService
     */
    public PlatformService getPlatformService() {
        return platformService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformService
     */
    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
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
    public MethodLinkBuilderFactory<PlatformsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<PlatformsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Platform
     */
    @ModelAttribute
    public Platform getPlatform(@PathVariable("platform") Long id, Locale locale, HttpMethod method) {
        Platform platform = null;
        if (HttpMethod.PUT.equals(method)) {
            platform = platformService.findOneForUpdate(id);
        } else {
            platform = platformService.findOne(id);
        }
        if (platform == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Platform", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return platform;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Platform platform, Model model) {
        model.addAttribute("platform", platform);

        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("functionAvarage");
        query.setParameter("platform", platform.getId());

        model.addAttribute("avaragegameprice", query.getSingleResult());

        return new ModelAndView("platforms/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Platform platform, Model model) {
        model.addAttribute("platform", platform);
        return new ModelAndView("platforms/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("premiere_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    public ConcurrencyTemplate<Platform> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "platform";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "platforms/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(Platform record) {
        return getPlatformService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(Platform entity, Model model) {
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
    @InitBinder("platform")
    public void initPlatformBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(Platform.class, getPlatformService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Platform platform, Model model) {
        populateForm(model);
        model.addAttribute("platform", platform);
        return new ModelAndView("platforms/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Platform platform, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Platform savedPlatform = getConcurrencyTemplate().execute(platform, model, new ConcurrencyCallback<Platform>() {

            @Override
            public Platform doInConcurrency(Platform platform) throws Exception {
                return getPlatformService().save(platform);
            }
        });
        UriComponents showURI = getItemLink().to(PlatformsItemThymeleafLinkFactory.SHOW).with("platform", savedPlatform.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Platform platform) {
        getPlatformService().delete(platform);
        return ResponseEntity.ok().build();
    }
}
