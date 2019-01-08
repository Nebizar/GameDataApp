package pl.put.poznan.gamebase.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import pl.put.poznan.gamebase.service.api.DLCService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.DLCRepository;
import pl.put.poznan.gamebase.structures.DLC;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = DLCServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = DLCService.class)
@Service
@Transactional(readOnly = true)
public class DLCServiceImpl implements DLCService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private DLCRepository dLCRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param dLCRepository
     */
    @Autowired
    public DLCServiceImpl(DLCRepository dLCRepository) {
        setDLCRepository(dLCRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return DLCRepository
     */
    public DLCRepository getDLCRepository() {
        return dLCRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dLCRepository
     */
    public void setDLCRepository(DLCRepository dLCRepository) {
        this.dLCRepository = dLCRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dlc
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(DLC dlc) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dLC
     */
    @Transactional
    public void delete(DLC dLC) {
        // Clear bidirectional many-to-one child relationship with Game
        if (dLC.getGame() != null) {
            dLC.getGame().getDlcs().remove(dLC);
        }
        getDLCRepository().delete(dLC);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<DLC> save(Iterable<DLC> entities) {
        return getDLCRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<DLC> toDelete = getDLCRepository().findAll(ids);
        getDLCRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return DLC
     */
    @Transactional
    public DLC save(DLC entity) {
        return getDLCRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DLC
     */
    public DLC findOne(Long id) {
        return getDLCRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return DLC
     */
    public DLC findOneForUpdate(Long id) {
        return getDLCRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<DLC> findAll(Iterable<Long> ids) {
        return getDLCRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<DLC> findAll() {
        return getDLCRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getDLCRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DLC> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getDLCRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DLC> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getDLCRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<DLC> findByGame(Game game, GlobalSearch globalSearch, Pageable pageable) {
        return getDLCRepository().findByGame(game, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param game
     * @return Long
     */
    public long countByGame(Game game) {
        return getDLCRepository().countByGame(game);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<DLC> getEntityType() {
        return DLC.class;
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
