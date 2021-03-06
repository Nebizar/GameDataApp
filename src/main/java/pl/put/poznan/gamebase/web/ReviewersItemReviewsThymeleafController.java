package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Reviewer;
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
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.service.api.ReviewerService;
import pl.put.poznan.gamebase.structures.Review;

/**
 * = ReviewersItemReviewsThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Reviewer.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "reviews", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/reviewers/{reviewer}/reviews", name = "ReviewersItemReviewsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class ReviewersItemReviewsThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReviewerService reviewerService;

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
    private ReviewService reviewService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ReviewersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reviewerService
     * @param reviewService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public ReviewersItemReviewsThymeleafController(ReviewerService reviewerService, ReviewService reviewService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setReviewerService(reviewerService);
        setReviewService(reviewService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(ReviewersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReviewerService
     */
    public ReviewerService getReviewerService() {
        return reviewerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewerService
     */
    public void setReviewerService(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
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
    public MethodLinkBuilderFactory<ReviewersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<ReviewersCollectionThymeleafController> collectionLink) {
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
     * @return Reviewer
     */
    @ModelAttribute
    public Reviewer getReviewer(@PathVariable("reviewer") Long id, Locale locale, HttpMethod method) {
        Reviewer reviewer = null;
        if (HttpMethod.PUT.equals(method)) {
            reviewer = reviewerService.findOneForUpdate(id);
        } else {
            reviewer = reviewerService.findOne(id);
        }
        if (reviewer == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Reviewer", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return reviewer;
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
     * @param reviewer
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Review>> datatables(@ModelAttribute Reviewer reviewer, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Review> reviews = getReviewService().findByReviewer(reviewer, search, pageable);
        long totalReviewsCount = getReviewService().countByReviewer(reviewer);
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
     * @param reviewer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Reviewer reviewer, Model model) {
        populateForm(model);
        model.addAttribute("review", new Review());
        return new ModelAndView("reviewers/reviews/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromReviews", value = "/{reviewsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromReviews(@ModelAttribute Reviewer reviewer, @PathVariable("reviewsToRemove") Long reviewsToRemove) {
        getReviewerService().removeFromReviews(reviewer, Collections.singleton(reviewsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviewsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromReviewsBatch", value = "/batch/{reviewsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromReviewsBatch(@ModelAttribute Reviewer reviewer, @PathVariable("reviewsToRemove") Collection<Long> reviewsToRemove) {
        getReviewerService().removeFromReviews(reviewer, reviewsToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reviewer
     * @param reviews
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Reviewer reviewer, @RequestParam(value = "reviewsIds", required = false) List<Long> reviews, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (reviews != null) {
            for (Iterator<Long> iterator = reviews.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, reviewer.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (reviews != null) {
                reviewer.setReviews(new HashSet<Review>(getReviewService().findAll(reviews)));
            } else {
                reviewer.setReviews(new HashSet<Review>());
            }
            // Reset the version to prevent update
            reviewer.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("reviewer", reviewer);
            model.addAttribute("concurrency", true);
            return new ModelAndView("reviewers/reviews/create");
        } else if (!Objects.equals(version, reviewer.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("reviewer", reviewer);
            model.addAttribute("concurrency", false);
            return new ModelAndView("reviewers/reviews/create");
        }
        getReviewerService().setReviews(reviewer, reviews);
        return new ModelAndView("redirect:" + getCollectionLink().to(ReviewersCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
