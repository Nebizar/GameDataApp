package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.PublisherService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.PublisherRepository;
import pl.put.poznan.gamebase.service.api.DevStudioService;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = PublisherServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = PublisherService.class)
@Service
@Transactional(readOnly = true)
public class PublisherServiceImpl implements PublisherService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DevStudioService devStudioService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PublisherRepository publisherRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param publisherRepository
     * @param devStudioService
     */
    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, @Lazy DevStudioService devStudioService) {
        setPublisherRepository(publisherRepository);
        setDevStudioService(devStudioService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PublisherRepository
     */
    public PublisherRepository getPublisherRepository() {
        return publisherRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisherRepository
     */
    public void setPublisherRepository(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
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
     * @param publisher
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Publisher publisher) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToAdd
     * @return Publisher
     */
    @Transactional
    public Publisher addToDev_studios(Publisher publisher, Iterable<Long> dev_studiosToAdd) {
        List<DevStudio> dev_studios = getDevStudioService().findAll(dev_studiosToAdd);
        publisher.addToDev_studios(dev_studios);
        return getPublisherRepository().save(publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studiosToRemove
     * @return Publisher
     */
    @Transactional
    public Publisher removeFromDev_studios(Publisher publisher, Iterable<Long> dev_studiosToRemove) {
        List<DevStudio> dev_studios = getDevStudioService().findAll(dev_studiosToRemove);
        publisher.removeFromDev_studios(dev_studios);
        return getPublisherRepository().save(publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param dev_studios
     * @return Publisher
     */
    @Transactional
    public Publisher setDev_studios(Publisher publisher, Iterable<Long> dev_studios) {
        List<DevStudio> items = getDevStudioService().findAll(dev_studios);
        Set<DevStudio> currents = publisher.getDev_studios();
        Set<DevStudio> toRemove = new HashSet<DevStudio>();
        for (Iterator<DevStudio> iterator = currents.iterator(); iterator.hasNext(); ) {
            DevStudio nextDevStudio = iterator.next();
            if (items.contains(nextDevStudio)) {
                items.remove(nextDevStudio);
            } else {
                toRemove.add(nextDevStudio);
            }
        }
        publisher.removeFromDev_studios(toRemove);
        publisher.addToDev_studios(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        publisher.setVersion(publisher.getVersion() + 1);
        return getPublisherRepository().save(publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     */
    @Transactional
    public void delete(Publisher publisher) {
        // Clear bidirectional one-to-many parent relationship with DevStudio
        for (DevStudio item : publisher.getDev_studios()) {
            item.setPublisher(null);
        }
        getPublisherRepository().delete(publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Publisher> save(Iterable<Publisher> entities) {
        return getPublisherRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Publisher> toDelete = getPublisherRepository().findAll(ids);
        getPublisherRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Publisher
     */
    @Transactional
    public Publisher save(Publisher entity) {
        return getPublisherRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Publisher
     */
    public Publisher findOne(Long id) {
        return getPublisherRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Publisher
     */
    public Publisher findOneForUpdate(Long id) {
        return getPublisherRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Publisher> findAll(Iterable<Long> ids) {
        return getPublisherRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Publisher> findAll() {
        return getPublisherRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPublisherRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Publisher> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPublisherRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Publisher> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getPublisherRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Publisher> getEntityType() {
        return Publisher.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
