package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Platform;

/**
 * = PlatformRepositoryImpl
 *
 * Implementation of PlatformRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = PlatformRepositoryCustom.class)
public class PlatformRepositoryImpl extends QueryDslRepositorySupportExt<Platform> implements PlatformRepositoryCustom{

    /**
     * Default constructor
     */
    PlatformRepositoryImpl() {
        super(Platform.class);
    }
}