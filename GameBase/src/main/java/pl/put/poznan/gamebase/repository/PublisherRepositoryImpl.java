package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Publisher;

/**
 * = PublisherRepositoryImpl
 *
 * Implementation of PublisherRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = PublisherRepositoryCustom.class)
public class PublisherRepositoryImpl extends QueryDslRepositorySupportExt<Publisher> implements PublisherRepositoryCustom{

    /**
     * Default constructor
     */
    PublisherRepositoryImpl() {
        super(Publisher.class);
    }
}