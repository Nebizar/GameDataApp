package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.PlatformService;
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
import pl.put.poznan.gamebase.repository.PlatformRepository;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = PlatformServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = PlatformService.class)
@Service
@Transactional(readOnly = true)
public class PlatformServiceImpl implements PlatformService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatService gamePlatService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PlatformRepository platformRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param platformRepository
     * @param gamePlatService
     */
    @Autowired
    public PlatformServiceImpl(PlatformRepository platformRepository, @Lazy GamePlatService gamePlatService) {
        setPlatformRepository(platformRepository);
        setGamePlatService(gamePlatService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PlatformRepository
     */
    public PlatformRepository getPlatformRepository() {
        return platformRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformRepository
     */
    public void setPlatformRepository(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
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
     * @param platform
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Platform platform) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToAdd
     * @return Platform
     */
    @Transactional
    public Platform addToGames(Platform platform, Iterable<Long> gamesToAdd) {
        List<GamePlat> games = getGamePlatService().findAll(gamesToAdd);
        platform.addToGames(games);
        return getPlatformRepository().save(platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToRemove
     * @return Platform
     */
    @Transactional
    public Platform removeFromGames(Platform platform, Iterable<Long> gamesToRemove) {
        List<GamePlat> games = getGamePlatService().findAll(gamesToRemove);
        platform.removeFromGames(games);
        return getPlatformRepository().save(platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param games
     * @return Platform
     */
    @Transactional
    public Platform setGames(Platform platform, Iterable<Long> games) {
        List<GamePlat> items = getGamePlatService().findAll(games);
        Set<GamePlat> currents = platform.getGames();
        Set<GamePlat> toRemove = new HashSet<GamePlat>();
        for (Iterator<GamePlat> iterator = currents.iterator(); iterator.hasNext(); ) {
            GamePlat nextGamePlat = iterator.next();
            if (items.contains(nextGamePlat)) {
                items.remove(nextGamePlat);
            } else {
                toRemove.add(nextGamePlat);
            }
        }
        platform.removeFromGames(toRemove);
        platform.addToGames(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        platform.setVersion(platform.getVersion() + 1);
        return getPlatformRepository().save(platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     */
    @Transactional
    public void delete(Platform platform) {
        // Clear bidirectional one-to-many parent relationship with GamePlat
        for (GamePlat item : platform.getGames()) {
            item.setPlatform(null);
        }
        getPlatformRepository().delete(platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Platform> save(Iterable<Platform> entities) {
        return getPlatformRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Platform> toDelete = getPlatformRepository().findAll(ids);
        getPlatformRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Platform
     */
    @Transactional
    public Platform save(Platform entity) {
        return getPlatformRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Platform
     */
    public Platform findOne(Long id) {
        return getPlatformRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Platform
     */
    public Platform findOneForUpdate(Long id) {
        return getPlatformRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Platform> findAll(Iterable<Long> ids) {
        return getPlatformRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Platform> findAll() {
        return getPlatformRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPlatformRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Platform> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPlatformRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Platform> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getPlatformRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Platform> getEntityType() {
        return Platform.class;
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
