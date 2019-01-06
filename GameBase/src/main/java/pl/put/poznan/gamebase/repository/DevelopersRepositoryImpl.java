package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Developers;

/**
 * = DevelopersRepositoryImpl
 *
 * Implementation of DevelopersRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = DevelopersRepositoryCustom.class)
public class DevelopersRepositoryImpl extends QueryDslRepositorySupportExt<Developers> implements DevelopersRepositoryCustom{

    /**
     * Default constructor
     */
    DevelopersRepositoryImpl() {
        super(Developers.class);
    }
}