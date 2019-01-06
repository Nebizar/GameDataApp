// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.structures;

import io.springlets.format.EntityFormat;
import javax.persistence.Entity;
import org.springframework.util.Assert;
import pl.put.poznan.gamebase.structures.DLC;
import pl.put.poznan.gamebase.structures.GamePlat;
import pl.put.poznan.gamebase.structures.Games;
import pl.put.poznan.gamebase.structures.Review;

privileged aspect Games_Roo_Jpa_Entity {
    
    declare @type: Games: @Entity;
    
    declare @type: Games: @EntityFormat("#{title}");
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String Games.ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String Games.ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param dlcsToAdd
     */
    public void Games.addToDlcs(Iterable<DLC> dlcsToAdd) {
        Assert.notNull(dlcsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (DLC item : dlcsToAdd) {
            this.dlcs.add(item);
            item.setGames(this);
        }
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param dlcsToRemove
     */
    public void Games.removeFromDlcs(Iterable<DLC> dlcsToRemove) {
        Assert.notNull(dlcsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (DLC item : dlcsToRemove) {
            this.dlcs.remove(item);
            item.setGames(null);
        }
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewsToAdd
     */
    public void Games.addToReviews(Iterable<Review> reviewsToAdd) {
        Assert.notNull(reviewsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Review item : reviewsToAdd) {
            this.reviews.add(item);
            item.setGames(this);
        }
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewsToRemove
     */
    public void Games.removeFromReviews(Iterable<Review> reviewsToRemove) {
        Assert.notNull(reviewsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Review item : reviewsToRemove) {
            this.reviews.remove(item);
            item.setGames(null);
        }
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platformsToAdd
     */
    public void Games.addToPlatforms(Iterable<GamePlat> platformsToAdd) {
        Assert.notNull(platformsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : platformsToAdd) {
            this.platforms.add(item);
            item.setGames(this);
        }
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param platformsToRemove
     */
    public void Games.removeFromPlatforms(Iterable<GamePlat> platformsToRemove) {
        Assert.notNull(platformsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (GamePlat item : platformsToRemove) {
            this.platforms.remove(item);
            item.setGames(null);
        }
    }
    
}
