package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.GameType;

/**
 * = GameTypeRepositoryImpl
 *
 * Implementation of GameTypeRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = GameTypeRepositoryCustom.class)
public class GameTypeRepositoryImpl extends QueryDslRepositorySupportExt<GameType> implements GameTypeRepositoryCustom{

    /**
     * Default constructor
     */
    GameTypeRepositoryImpl() {
        super(GameType.class);
    }
}