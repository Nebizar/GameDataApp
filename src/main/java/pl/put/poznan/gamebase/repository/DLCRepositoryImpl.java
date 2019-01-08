package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.DLC;

/**
 * = DLCRepositoryImpl
 *
 * Implementation of DLCRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = DLCRepositoryCustom.class)
public class DLCRepositoryImpl extends QueryDslRepositorySupportExt<DLC> implements DLCRepositoryCustom{

    /**
     * Default constructor
     */
    DLCRepositoryImpl() {
        super(DLC.class);
    }
}