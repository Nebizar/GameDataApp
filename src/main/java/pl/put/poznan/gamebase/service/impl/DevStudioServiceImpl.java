package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.DevStudioService;
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
import pl.put.poznan.gamebase.repository.DevStudioRepository;
import pl.put.poznan.gamebase.service.api.DeveloperService;
import pl.put.poznan.gamebase.service.api.GameService;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Developer;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Publisher;
import javax.persistence.EntityManager;

/**
 * = DevStudioServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = DevStudioService.class)
@Service
@Transactional(readOnly = true)
public class DevStudioServiceImpl implements DevStudioService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DeveloperService developerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GameService gameService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DevStudioRepository devStudioRepository;
    
    @Autowired
    private EntityManager em;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param devStudioRepository
     * @param developerService
     * @param gameService
     */
    @Autowired
    public DevStudioServiceImpl(DevStudioRepository devStudioRepository, @Lazy DeveloperService developerService, @Lazy GameService gameService) {
        setDevStudioRepository(devStudioRepository);
        setDeveloperService(developerService);
        setGameService(gameService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return DevStudioRepository
     */
    public DevStudioRepository getDevStudioRepository() {
        return devStudioRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudioRepository
     */
    public void setDevStudioRepository(DevStudioRepository devStudioRepository) {
        this.devStudioRepository = devStudioRepository;
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
     * @param devstudio
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(DevStudio devstudio) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToAdd
     * @return DevStudio
     */
    @Transactional
    public DevStudio addToDevelopers(DevStudio devStudio, Iterable<Long> developersToAdd) {
        List<Developer> developers = getDeveloperService().findAll(developersToAdd);
        devStudio.addToDevelopers(developers);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param gamesToAdd
     * @return DevStudio
     */
    @Transactional
    public DevStudio addToGames(DevStudio devStudio, Iterable<Long> gamesToAdd) {
        List<Game> games = getGameService().findAll(gamesToAdd);
        devStudio.addToGames(games);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developersToRemove
     * @return DevStudio
     */
    @Transactional
    public DevStudio removeFromDevelopers(DevStudio devStudio, Iterable<Long> developersToRemove) {
        List<Developer> developers = getDeveloperService().findAll(developersToRemove);
        devStudio.removeFromDevelopers(developers);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param gamesToRemove
     * @return DevStudio
     */
    @Transactional
    public DevStudio removeFromGames(DevStudio devStudio, Iterable<Long> gamesToRemove) {
        List<Game> games = getGameService().findAll(gamesToRemove);
        devStudio.removeFromGames(games);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param developers
     * @return DevStudio
     */
    @Transactional
    public DevStudio setDevelopers(DevStudio devStudio, Iterable<Long> developers) {
        List<Developer> items = getDeveloperService().findAll(developers);
        Set<Developer> currents = devStudio.getDevelopers();
        Set<Developer> toRemove = new HashSet<Developer>();
        for (Iterator<Developer> iterator = currents.iterator(); iterator.hasNext(); ) {
            Developer nextDeveloper = iterator.next();
            if (items.contains(nextDeveloper)) {
                items.remove(nextDeveloper);
            } else {
                toRemove.add(nextDeveloper);
            }
        }
        devStudio.removeFromDevelopers(toRemove);
        devStudio.addToDevelopers(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        devStudio.setVersion(devStudio.getVersion() + 1);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     * @param games
     * @return DevStudio
     */
    @Transactional
    public DevStudio setGames(DevStudio devStudio, Iterable<Long> games) {
        List<Game> items = getGameService().findAll(games);
        Set<Game> currents = devStudio.getGames();
        Set<Game> toRemove = new HashSet<Game>();
        for (Iterator<Game> iterator = currents.iterator(); iterator.hasNext(); ) {
            Game nextGame = iterator.next();
            if (items.contains(nextGame)) {
                items.remove(nextGame);
            } else {
                toRemove.add(nextGame);
            }
        }
        devStudio.removeFromGames(toRemove);
        devStudio.addToGames(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        devStudio.setVersion(devStudio.getVersion() + 1);
        return getDevStudioRepository().save(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param devStudio
     */
    @Transactional
    public void delete(DevStudio devStudio) {
        // Clear bidirectional many-to-one child relationship with Publisher
        if (devStudio.getPublisher() != null) {
            devStudio.getPublisher().getDev_studios().remove(devStudio);
        }
        // Clear bidirectional one-to-many parent relationship with Developer
        for (Developer item : devStudio.getDevelopers()) {
            item.setDevstudio(null);
        }
        // Clear bidirectional one-to-many parent relationship with Game
        for (Game item : devStudio.getGames()) {
            item.setDevstudio(null);
        }
        getDevStudioRepository().delete(devStudio);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<DevStudio> save(Iterable<DevStudio> entities) {
        return getDevStudioRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<DevStudio> toDelete = getDevStudioRepository().findAll(ids);
        getDevStudioRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return DevStudio
     */
    @Transactional
    public DevStudio save(DevStudio entity) {
        return getDevStudioRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DevStudio
     */
    public DevStudio findOne(Long id) {
        return getDevStudioRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DevStudio
     */
    public DevStudio findOneForUpdate(Long id) {
        return getDevStudioRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<DevStudio> findAll(Iterable<Long> ids) {
        return getDevStudioRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<DevStudio> findAll() {
        return getDevStudioRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getDevStudioRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getDevStudioRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getDevStudioRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DevStudio> findByPublisher(Publisher publisher, GlobalSearch globalSearch, Pageable pageable) {
        return getDevStudioRepository().findByPublisher(publisher, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param publisher
     * @return Long
     */
    public long countByPublisher(Publisher publisher) {
        return getDevStudioRepository().countByPublisher(publisher);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<DevStudio> getEntityType() {
        return DevStudio.class;
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
