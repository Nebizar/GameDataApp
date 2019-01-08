package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.GamePlatRepository;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = GamePlatServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = GamePlatService.class)
@Service
@Transactional(readOnly = true)
public class GamePlatServiceImpl implements GamePlatService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatRepository gamePlatRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param gamePlatRepository
     */
    @Autowired
    public GamePlatServiceImpl(GamePlatRepository gamePlatRepository) {
        setGamePlatRepository(gamePlatRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GamePlatRepository
     */
    public GamePlatRepository getGamePlatRepository() {
        return gamePlatRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlatRepository
     */
    public void setGamePlatRepository(GamePlatRepository gamePlatRepository) {
        this.gamePlatRepository = gamePlatRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gameplat
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(GamePlat gameplat) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlat
     */
    @Transactional
    public void delete(GamePlat gamePlat) {
        // Clear bidirectional many-to-one child relationship with Game
        if (gamePlat.getGame() != null) {
            gamePlat.getGame().getPlatforms().remove(gamePlat);
        }
        // Clear bidirectional many-to-one child relationship with Platform
        if (gamePlat.getPlatform() != null) {
            gamePlat.getPlatform().getGames().remove(gamePlat);
        }
        getGamePlatRepository().delete(gamePlat);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<GamePlat> save(Iterable<GamePlat> entities) {
        return getGamePlatRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<GamePlat> toDelete = getGamePlatRepository().findAll(ids);
        getGamePlatRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return GamePlat
     */
    @Transactional
    public GamePlat save(GamePlat entity) {
        return getGamePlatRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GamePlat
     */
    public GamePlat findOne(Long id) {
        return getGamePlatRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return GamePlat
     */
    public GamePlat findOneForUpdate(Long id) {
        return getGamePlatRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<GamePlat> findAll(Iterable<Long> ids) {
        return getGamePlatRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<GamePlat> findAll() {
        return getGamePlatRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getGamePlatRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findByGame(game, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> findByPlatform(Platform platform, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findByPlatform(platform, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public long countByGame(Game game) {
        return getGamePlatRepository().countByGame(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @return Long
     */
    public long countByPlatform(Platform platform) {
        return getGamePlatRepository().countByPlatform(platform);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<GamePlat> getEntityType() {
        return GamePlat.class;
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
