package pl.put.poznan.gamebase.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.GamePlat;

/**
 * = GamePlatRepositoryImpl
 *
 * Implementation of GamePlatRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = GamePlatRepositoryCustom.class)
public class GamePlatRepositoryImpl extends QueryDslRepositorySupportExt<GamePlat> implements GamePlatRepositoryCustom{

    /**
     * Default constructor
     */
    GamePlatRepositoryImpl() {
        super(GamePlat.class);
    }
}