// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.repository;

import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.DLCRepository;
import pl.put.poznan.gamebase.structures.Games;

privileged aspect DLCRepository_Roo_Jpa_Repository {
    
    declare @type: DLCRepository: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param games
     * @return Long
     */
    public abstract long DLCRepository.countByGames(Games games);
    
}
