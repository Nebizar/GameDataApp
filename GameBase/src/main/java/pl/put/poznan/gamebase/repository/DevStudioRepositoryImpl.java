package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.DevStudio;

/**
 * = DevStudioRepositoryImpl
 *
 * Implementation of DevStudioRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = DevStudioRepositoryCustom.class)
public class DevStudioRepositoryImpl extends QueryDslRepositorySupportExt<DevStudio> implements DevStudioRepositoryCustom{

    /**
     * Default constructor
     */
    DevStudioRepositoryImpl() {
        super(DevStudio.class);
    }
}