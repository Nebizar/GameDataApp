package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Games;

/**
 * = GamesRepositoryImpl
 *
 * Implementation of GamesRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = GamesRepositoryCustom.class)
public class GamesRepositoryImpl extends QueryDslRepositorySupportExt<Games> implements GamesRepositoryCustom{

    /**
     * Default constructor
     */
    GamesRepositoryImpl() {
        super(Games.class);
    }
}