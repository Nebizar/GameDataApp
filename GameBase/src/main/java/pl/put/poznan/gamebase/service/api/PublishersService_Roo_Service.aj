// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.service.api;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.service.api.PublishersService;
import pl.put.poznan.gamebase.structures.Publishers;

privileged aspect PublishersService_Roo_Service {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Publishers
     */
    public abstract Publishers PublishersService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param publishers
     */
    public abstract void PublishersService.delete(Publishers publishers);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Publishers> PublishersService.save(Iterable<Publishers> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void PublishersService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Publishers
     */
    public abstract Publishers PublishersService.save(Publishers entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Publishers
     */
    public abstract Publishers PublishersService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Publishers> PublishersService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Publishers> PublishersService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long PublishersService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Publishers> PublishersService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Publishers> PublishersService.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param publishers
     * @param dev_studiosToAdd
     * @return Publishers
     */
    public abstract Publishers PublishersService.addToDev_studios(Publishers publishers, Iterable<Long> dev_studiosToAdd);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param publishers
     * @param dev_studiosToRemove
     * @return Publishers
     */
    public abstract Publishers PublishersService.removeFromDev_studios(Publishers publishers, Iterable<Long> dev_studiosToRemove);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param publishers
     * @param dev_studios
     * @return Publishers
     */
    public abstract Publishers PublishersService.setDev_studios(Publishers publishers, Iterable<Long> dev_studios);
    
}
