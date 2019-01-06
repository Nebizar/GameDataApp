package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Publishers;

/**
 * = PublishersRepositoryImpl
 *
 * Implementation of PublishersRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = PublishersRepositoryCustom.class)
public class PublishersRepositoryImpl extends QueryDslRepositorySupportExt<Publishers> implements PublishersRepositoryCustom{

    /**
     * Default constructor
     */
    PublishersRepositoryImpl() {
        super(Publishers.class);
    }
}