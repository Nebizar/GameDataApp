// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.repository;

import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.DeveloperRepository;
import pl.put.poznan.gamebase.structures.DevStudio;

privileged aspect DeveloperRepository_Roo_Jpa_Repository {
    
    declare @type: DeveloperRepository: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param devstudio
     * @return Long
     */
    public abstract long DeveloperRepository.countByDevstudio(DevStudio devstudio);
    
}