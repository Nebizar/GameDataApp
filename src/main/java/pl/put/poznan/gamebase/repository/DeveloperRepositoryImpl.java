package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Developer;

/**
 * = DeveloperRepositoryImpl
 *
 * Implementation of DeveloperRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = DeveloperRepositoryCustom.class)
public class DeveloperRepositoryImpl extends QueryDslRepositorySupportExt<Developer> implements DeveloperRepositoryCustom{

    /**
     * Default constructor
     */
    DeveloperRepositoryImpl() {
        super(Developer.class);
    }
}