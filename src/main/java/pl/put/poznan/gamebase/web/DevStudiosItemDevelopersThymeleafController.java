package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.DevStudio;
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
import pl.put.poznan.gamebase.service.api.DevStudioService;
import pl.put.poznan.gamebase.service.api.DeveloperService;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DevStudiosItemDevelopersThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = DevStudio.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "developers", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/devstudios/{devStudio}/developers", name = "DevStudiosItemDevelopersThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class DevStudiosItemDevelopersThymeleafController {

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
    private DevStudioService devStudioService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DeveloperService developerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<DevStudiosCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param devStudioService
     * @param developerService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public DevStudiosItemDevelopersThymeleafController(DevStudioService devStudioService, DeveloperService developerService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setDevStudioService(devStudioService);
        setDeveloperService(developerService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(DevStudiosCollectionThymeleafController.class));
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
     * @return DeveloperService
     */
    public DeveloperService getDeveloperService() {
        return developerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developerService
     */
    public void setDeveloperService(DeveloperService developerService) {
        this.developerService = developerService;
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
     * @param devstudio
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Developer>> datatables(@ModelAttribute DevStudio devstudio, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Developer> developers = getDeveloperService().findByDevstudio(devstudio, search, pageable);
        long totalDevelopersCount = getDeveloperService().countByDevstudio(devstudio);
        ConvertedDatatablesData<Developer> data = new ConvertedDatatablesData<Developer>(developers, totalDevelopersCount, draw, getConversionService(), datatablesColumns);
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
    public ResponseEntity<ConvertedDatatablesData<Developer>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Developer> developers = getDeveloperService().findAllByIdsIn(ids, search, pageable);
        long totalDevelopersCount = developers.getTotalElements();
        ConvertedDatatablesData<Developer> data = new ConvertedDatatablesData<Developer>(developers, totalDevelopersCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute DevStudio devStudio, Model model) {
        populateForm(model);
        model.addAttribute("developer", new Developer());
        return new ModelAndView("devstudios/developers/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromDevelopers", value = "/{developersToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromDevelopers(@ModelAttribute DevStudio devStudio, @PathVariable("developersToRemove") Long developersToRemove) {
        getDevStudioService().removeFromDevelopers(devStudio, Collections.singleton(developersToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromDevelopersBatch", value = "/batch/{developersToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromDevelopersBatch(@ModelAttribute DevStudio devStudio, @PathVariable("developersToRemove") Collection<Long> developersToRemove) {
        getDevStudioService().removeFromDevelopers(devStudio, developersToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developers
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute DevStudio devStudio, @RequestParam(value = "developersIds", required = false) List<Long> developers, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (developers != null) {
            for (Iterator<Long> iterator = developers.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, devStudio.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (developers != null) {
                devStudio.setDevelopers(new HashSet<Developer>(getDeveloperService().findAll(developers)));
            } else {
                devStudio.setDevelopers(new HashSet<Developer>());
            }
            // Reset the version to prevent update
            devStudio.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("devStudio", devStudio);
            model.addAttribute("concurrency", true);
            return new ModelAndView("devstudios/developers/create");
        } else if (!Objects.equals(version, devStudio.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("devStudio", devStudio);
            model.addAttribute("concurrency", false);
            return new ModelAndView("devstudios/developers/create");
        }
        getDevStudioService().setDevelopers(devStudio, developers);
        return new ModelAndView("redirect:" + getCollectionLink().to(DevStudiosCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
