// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.service.api;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.service.api.PlatformService;
import pl.put.poznan.gamebase.structures.Platform;

privileged aspect PlatformService_Roo_Service {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Platform
     */
    public abstract Platform PlatformService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     */
    public abstract void PlatformService.delete(Platform platform);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Platform> PlatformService.save(Iterable<Platform> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void PlatformService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Platform
     */
    public abstract Platform PlatformService.save(Platform entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Platform
     */
    public abstract Platform PlatformService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Platform> PlatformService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Platform> PlatformService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long PlatformService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Platform> PlatformService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Platform> PlatformService.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     * @param gamesToAdd
     * @return Platform
     */
    public abstract Platform PlatformService.addToGames(Platform platform, Iterable<Long> gamesToAdd);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     * @param gamesToRemove
     * @return Platform
     */
    public abstract Platform PlatformService.removeFromGames(Platform platform, Iterable<Long> gamesToRemove);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platform
     * @param games
     * @return Platform
     */
    public abstract Platform PlatformService.setGames(Platform platform, Iterable<Long> games);
    
}
