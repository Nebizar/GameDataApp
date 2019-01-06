// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.repository;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.repository.GamesRepositoryCustom;
import pl.put.poznan.gamebase.structures.DevStudio;
import pl.put.poznan.gamebase.structures.Games;
import pl.put.poznan.gamebase.structures.Type;

privileged aspect GamesRepositoryCustom_Roo_Jpa_Repository_Custom {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param devstudio
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Games> GamesRepositoryCustom.findByDevstudio(DevStudio devstudio, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param type
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Games> GamesRepositoryCustom.findByType(Type type, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Games> GamesRepositoryCustom.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Games> GamesRepositoryCustom.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
}
