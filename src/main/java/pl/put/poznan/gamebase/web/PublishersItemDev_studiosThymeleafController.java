package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Publisher;
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
import pl.put.poznan.gamebase.service.api.PublisherService;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = PublishersItemDev_studiosThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Publisher.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "dev_studios", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/publishers/{publisher}/dev_studios", name = "PublishersItemDev_studiosThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class PublishersItemDev_studiosThymeleafController {

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
    private MethodLinkBuilderFactory<PublishersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PublisherService publisherService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param publisherService
     * @param devStudioService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PublishersItemDev_studiosThymeleafController(PublisherService publisherService, DevStudioService devStudioService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setPublisherService(publisherService);
        setDevStudioService(devStudioService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(PublishersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PublisherService
     */
    public PublisherService getPublisherService() {
        return publisherService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisherService
     */
    public void setPublisherService(PublisherService publisherService) {
        this.publisherService = publisherService;
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
    public MethodLinkBuilderFactory<PublishersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<PublishersCollectionThymeleafController> collectionLink) {
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
     * @return Publisher
     */
    @ModelAttribute
    public Publisher getPublisher(@PathVariable("publisher") Long id, Locale locale, HttpMethod method) {
        Publisher publisher = null;
        if (HttpMethod.PUT.equals(method)) {
            publisher = publisherService.findOneForUpdate(id);
        } else {
            publisher = publisherService.findOne(id);
        }
        if (publisher == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Publisher", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return publisher;
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
     * @param publisher
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<DevStudio>> datatables(@ModelAttribute Publisher publisher, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<DevStudio> dev_studios = getDevStudioService().findByPublisher(publisher, search, pageable);
        long totalDev_studiosCount = getDevStudioService().countByPublisher(publisher);
        ConvertedDatatablesData<DevStudio> data = new ConvertedDatatablesData<DevStudio>(dev_studios, totalDev_studiosCount, draw, getConversionService(), datatablesColumns);
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
    public ResponseEntity<ConvertedDatatablesData<DevStudio>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<DevStudio> dev_studios = getDevStudioService().findAllByIdsIn(ids, search, pageable);
        long totalDev_studiosCount = dev_studios.getTotalElements();
        ConvertedDatatablesData<DevStudio> data = new ConvertedDatatablesData<DevStudio>(dev_studios, totalDev_studiosCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Publisher publisher, Model model) {
        populateForm(model);
        model.addAttribute("devStudio", new DevStudio());
        return new ModelAndView("publishers/dev_studios/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromDev_studios", value = "/{dev_studiosToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromDev_studios(@ModelAttribute Publisher publisher, @PathVariable("dev_studiosToRemove") Long dev_studiosToRemove) {
        getPublisherService().removeFromDev_studios(publisher, Collections.singleton(dev_studiosToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromDev_studiosBatch", value = "/batch/{dev_studiosToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromDev_studiosBatch(@ModelAttribute Publisher publisher, @PathVariable("dev_studiosToRemove") Collection<Long> dev_studiosToRemove) {
        getPublisherService().removeFromDev_studios(publisher, dev_studiosToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studios
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Publisher publisher, @RequestParam(value = "dev_studiosIds", required = false) List<Long> dev_studios, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (dev_studios != null) {
            for (Iterator<Long> iterator = dev_studios.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, publisher.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (dev_studios != null) {
                publisher.setDev_studios(new HashSet<DevStudio>(getDevStudioService().findAll(dev_studios)));
            } else {
                publisher.setDev_studios(new HashSet<DevStudio>());
            }
            // Reset the version to prevent update
            publisher.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("publisher", publisher);
            model.addAttribute("concurrency", true);
            return new ModelAndView("publishers/dev_studios/create");
        } else if (!Objects.equals(version, publisher.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("publisher", publisher);
            model.addAttribute("concurrency", false);
            return new ModelAndView("publishers/dev_studios/create");
        }
        getPublisherService().setDev_studios(publisher, dev_studios);
        return new ModelAndView("redirect:" + getCollectionLink().to(PublishersCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
