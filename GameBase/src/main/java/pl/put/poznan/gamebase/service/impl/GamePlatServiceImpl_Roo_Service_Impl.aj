// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.service.impl;

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
import pl.put.poznan.gamebase.service.impl.GamePlatServiceImpl;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.Games;
import pl.put.poznan.gamebase.structures.Platform;

privileged aspect GamePlatServiceImpl_Roo_Service_Impl {
    
    declare @type: GamePlatServiceImpl: @Service;
    
    declare @type: GamePlatServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private GamePlatRepository GamePlatServiceImpl.gamePlatRepository;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param gamePlatRepository
     */
    @Autowired
    public GamePlatServiceImpl.new(GamePlatRepository gamePlatRepository) {
        setGamePlatRepository(gamePlatRepository);
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @return GamePlatRepository
     */
    public GamePlatRepository GamePlatServiceImpl.getGamePlatRepository() {
        return gamePlatRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gamePlatRepository
     */
    public void GamePlatServiceImpl.setGamePlatRepository(GamePlatRepository gamePlatRepository) {
        this.gamePlatRepository = gamePlatRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameplat
     * @return Map
     */
    public Map<String, List<MessageI18n>> GamePlatServiceImpl.validate(GamePlat gameplat) {
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
    public void GamePlatServiceImpl.delete(GamePlat gamePlat) {
        // Clear bidirectional many-to-one child relationship with Games
        if (gamePlat.getGames() != null) {
            gamePlat.getGames().getPlatforms().remove(gamePlat);
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
    public List<GamePlat> GamePlatServiceImpl.save(Iterable<GamePlat> entities) {
        return getGamePlatRepository().save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void GamePlatServiceImpl.delete(Iterable<Long> ids) {
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
    public GamePlat GamePlatServiceImpl.save(GamePlat entity) {
        return getGamePlatRepository().save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return GamePlat
     */
    public GamePlat GamePlatServiceImpl.findOne(Long id) {
        return getGamePlatRepository().findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return GamePlat
     */
    public GamePlat GamePlatServiceImpl.findOneForUpdate(Long id) {
        return getGamePlatRepository().findOneDetached(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<GamePlat> GamePlatServiceImpl.findAll(Iterable<Long> ids) {
        return getGamePlatRepository().findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<GamePlat> GamePlatServiceImpl.findAll() {
        return getGamePlatRepository().findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long GamePlatServiceImpl.count() {
        return getGamePlatRepository().count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> GamePlatServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
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
    public Page<GamePlat> GamePlatServiceImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param games
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> GamePlatServiceImpl.findByGames(Games games, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findByGames(games, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GamePlat> GamePlatServiceImpl.findByPlatform(Platform platform, GlobalSearch globalSearch, Pageable pageable) {
        return getGamePlatRepository().findByPlatform(platform, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param games
     * @return Long
     */
    public long GamePlatServiceImpl.countByGames(Games games) {
        return getGamePlatRepository().countByGames(games);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     * @return Long
     */
    public long GamePlatServiceImpl.countByPlatform(Platform platform) {
        return getGamePlatRepository().countByPlatform(platform);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<GamePlat> GamePlatServiceImpl.getEntityType() {
        return GamePlat.class;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Long> GamePlatServiceImpl.getIdType() {
        return Long.class;
    }
    
}
