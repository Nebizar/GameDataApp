// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.service.impl;

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
import pl.put.poznan.gamebase.repository.GameTypeRepository;
import pl.put.poznan.gamebase.service.api.GameService;
import pl.put.poznan.gamebase.service.impl.GameTypeServiceImpl;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.GameType;

privileged aspect GameTypeServiceImpl_Roo_Service_Impl {
    
    declare @type: GameTypeServiceImpl: @Service;
    
    declare @type: GameTypeServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private GameTypeRepository GameTypeServiceImpl.gameTypeRepository;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private GameService GameTypeServiceImpl.gameService;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param gameTypeRepository
     * @param gameService
     */
    @Autowired
    public GameTypeServiceImpl.new(GameTypeRepository gameTypeRepository, @Lazy GameService gameService) {
        setGameTypeRepository(gameTypeRepository);
        setGameService(gameService);
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @return GameTypeRepository
     */
    public GameTypeRepository GameTypeServiceImpl.getGameTypeRepository() {
        return gameTypeRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameTypeRepository
     */
    public void GameTypeServiceImpl.setGameTypeRepository(GameTypeRepository gameTypeRepository) {
        this.gameTypeRepository = gameTypeRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return GameService
     */
    public GameService GameTypeServiceImpl.getGameService() {
        return gameService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameService
     */
    public void GameTypeServiceImpl.setGameService(GameService gameService) {
        this.gameService = gameService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gametype
     * @return Map
     */
    public Map<String, List<MessageI18n>> GameTypeServiceImpl.validate(GameType gametype) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        
        return messages;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameType
     * @param gamesToAdd
     * @return GameType
     */
    @Transactional
    public GameType GameTypeServiceImpl.addToGames(GameType gameType, Iterable<Long> gamesToAdd) {
        List<Game> games = getGameService().findAll(gamesToAdd);
        gameType.addToGames(games);
        return getGameTypeRepository().save(gameType);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameType
     * @param gamesToRemove
     * @return GameType
     */
    @Transactional
    public GameType GameTypeServiceImpl.removeFromGames(GameType gameType, Iterable<Long> gamesToRemove) {
        List<Game> games = getGameService().findAll(gamesToRemove);
        gameType.removeFromGames(games);
        return getGameTypeRepository().save(gameType);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameType
     * @param games
     * @return GameType
     */
    @Transactional
    public GameType GameTypeServiceImpl.setGames(GameType gameType, Iterable<Long> games) {
        List<Game> items = getGameService().findAll(games);
        Set<Game> currents = gameType.getGames();
        Set<Game> toRemove = new HashSet<Game>();
        for (Iterator<Game> iterator = currents.iterator(); iterator.hasNext();) {
            Game nextGame = iterator.next();
            if (items.contains(nextGame)) {
                items.remove(nextGame);
            } else {
                toRemove.add(nextGame);
            }
        }
        gameType.removeFromGames(toRemove);
        gameType.addToGames(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        gameType.setVersion(gameType.getVersion() + 1);
        return getGameTypeRepository().save(gameType);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param gameType
     */
    @Transactional
    public void GameTypeServiceImpl.delete(GameType gameType) {
        // Clear bidirectional one-to-many parent relationship with Game
        for (Game item : gameType.getGames()) {
            item.setGametype(null);
        }
        
        getGameTypeRepository().delete(gameType);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<GameType> GameTypeServiceImpl.save(Iterable<GameType> entities) {
        return getGameTypeRepository().save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void GameTypeServiceImpl.delete(Iterable<Long> ids) {
        List<GameType> toDelete = getGameTypeRepository().findAll(ids);
        getGameTypeRepository().deleteInBatch(toDelete);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return GameType
     */
    @Transactional
    public GameType GameTypeServiceImpl.save(GameType entity) {
        return getGameTypeRepository().save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return GameType
     */
    public GameType GameTypeServiceImpl.findOne(Long id) {
        return getGameTypeRepository().findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return GameType
     */
    public GameType GameTypeServiceImpl.findOneForUpdate(Long id) {
        return getGameTypeRepository().findOneDetached(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<GameType> GameTypeServiceImpl.findAll(Iterable<Long> ids) {
        return getGameTypeRepository().findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<GameType> GameTypeServiceImpl.findAll() {
        return getGameTypeRepository().findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long GameTypeServiceImpl.count() {
        return getGameTypeRepository().count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GameType> GameTypeServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getGameTypeRepository().findAll(globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<GameType> GameTypeServiceImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getGameTypeRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<GameType> GameTypeServiceImpl.getEntityType() {
        return GameType.class;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Long> GameTypeServiceImpl.getIdType() {
        return Long.class;
    }
    
}