// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.repository;

import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.repository.PublishersRepository;

privileged aspect PublishersRepository_Roo_Jpa_Repository {
    
    declare @type: PublishersRepository: @Transactional(readOnly = true);
    
}
