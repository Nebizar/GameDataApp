package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Game;

/**
 * = GameRepositoryImpl
 *
 * Implementation of GameRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = GameRepositoryCustom.class)
public class GameRepositoryImpl extends QueryDslRepositorySupportExt<Game> implements GameRepositoryCustom{

    /**
     * Default constructor
     */
    GameRepositoryImpl() {
        super(Game.class);
    }
}