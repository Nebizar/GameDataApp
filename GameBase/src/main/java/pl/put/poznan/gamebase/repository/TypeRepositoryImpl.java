package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Type;

/**
 * = TypeRepositoryImpl
 *
 * Implementation of TypeRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = TypeRepositoryCustom.class)
public class TypeRepositoryImpl extends QueryDslRepositorySupportExt<Type> implements TypeRepositoryCustom{

    /**
     * Default constructor
     */
    TypeRepositoryImpl() {
        super(Type.class);
    }
}