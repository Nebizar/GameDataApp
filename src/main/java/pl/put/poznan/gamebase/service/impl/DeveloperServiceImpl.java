package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.DeveloperService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.DeveloperRepository;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DeveloperServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = DeveloperService.class)
@Service
@Transactional(readOnly = true)
public class DeveloperServiceImpl implements DeveloperService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DeveloperRepository developerRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param developerRepository
     */
    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        setDeveloperRepository(developerRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return DeveloperRepository
     */
    public DeveloperRepository getDeveloperRepository() {
        return developerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developerRepository
     */
    public void setDeveloperRepository(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developer
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Developer developer) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param developer
     */
    @Transactional
    public void delete(Developer developer) {
        // Clear bidirectional many-to-one child relationship with DevStudio
        if (developer.getDevstudio() != null) {
            developer.getDevstudio().getDevelopers().remove(developer);
        }
        getDeveloperRepository().delete(developer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Developer> save(Iterable<Developer> entities) {
        return getDeveloperRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Developer> toDelete = getDeveloperRepository().findAll(ids);
        getDeveloperRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Developer
     */
    @Transactional
    public Developer save(Developer entity) {
        return getDeveloperRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Developer
     */
    public Developer findOne(Long id) {
        return getDeveloperRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Developer
     */
    public Developer findOneForUpdate(Long id) {
        return getDeveloperRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Developer> findAll(Iterable<Long> ids) {
        return getDeveloperRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Developer> findAll() {
        return getDeveloperRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getDeveloperRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getDeveloperRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getDeveloperRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Developer> findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable) {
        return getDeveloperRepository().findByDevstudio(devstudio, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devstudio
     * @return Long
     */
    public long countByDevstudio(DevStudio devstudio) {
        return getDeveloperRepository().countByDevstudio(devstudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Developer> getEntityType() {
        return Developer.class;
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
