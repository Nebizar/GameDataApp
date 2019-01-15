package pl.put.poznan.gamebase.web;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.DevStudio;
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
import pl.put.poznan.gamebase.service.api.DevStudioService;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

/**
 * = DevStudiosItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = DevStudio.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/devstudios/{devStudio}", name = "DevStudiosItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class DevStudiosItemThymeleafController implements ConcurrencyManager<DevStudio> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<DevStudio> concurrencyTemplate = new ConcurrencyTemplate<DevStudio>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<DevStudiosItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DevStudioService devStudioService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<DevStudiosCollectionThymeleafController> collectionLink;
    
    private EntityManager em;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param devStudioService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public DevStudiosItemThymeleafController(DevStudioService devStudioService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder, EntityManager em) {
        setDevStudioService(devStudioService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(DevStudiosItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(DevStudiosCollectionThymeleafController.class));
        this.em = em;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return DevStudioService
     */
    public DevStudioService getDevStudioService() {
        return devStudioService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudioService
     */
    public void setDevStudioService(DevStudioService devStudioService) {
        this.devStudioService = devStudioService;
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
    public MethodLinkBuilderFactory<DevStudiosItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<DevStudiosItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<DevStudiosCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<DevStudiosCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return DevStudio
     */
    @ModelAttribute
    public DevStudio getDevStudio(@PathVariable("devStudio") Long id, Locale locale, HttpMethod method) {
        DevStudio devStudio = null;
        if (HttpMethod.PUT.equals(method)) {
            devStudio = devStudioService.findOneForUpdate(id);
        } else {
            devStudio = devStudioService.findOne(id);
        }
        if (devStudio == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "DevStudio", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return devStudio;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute DevStudio devStudio, Model model) {
        model.addAttribute("devStudio", devStudio);
        
        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("functionNewGame");
        query.setParameter("id_dev", devStudio.getId());

        model.addAttribute("get_newest_game", query.getSingleResult());
        
        return new ModelAndView("devstudios/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute DevStudio devStudio, Model model) {
        model.addAttribute("devStudio", devStudio);
        return new ModelAndView("devstudios/showInline :: inline-content");
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
    public ConcurrencyTemplate<DevStudio> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "devStudio";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "devstudios/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(DevStudio record) {
        return getDevStudioService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(DevStudio entity, Model model) {
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
    @InitBinder("devStudio")
    public void initDevStudioBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(DevStudio.class, getDevStudioService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute DevStudio devStudio, Model model) {
        populateForm(model);
        model.addAttribute("devStudio", devStudio);
        return new ModelAndView("devstudios/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute DevStudio devStudio, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        DevStudio savedDevStudio = getConcurrencyTemplate().execute(devStudio, model, new ConcurrencyCallback<DevStudio>() {

            @Override
            public DevStudio doInConcurrency(DevStudio devStudio) throws Exception {
                return getDevStudioService().save(devStudio);
            }
        });
        UriComponents showURI = getItemLink().to(DevStudiosItemThymeleafLinkFactory.SHOW).with("devStudio", savedDevStudio.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute DevStudio devStudio) {
        getDevStudioService().delete(devStudio);
        return ResponseEntity.ok().build();
    }
}
