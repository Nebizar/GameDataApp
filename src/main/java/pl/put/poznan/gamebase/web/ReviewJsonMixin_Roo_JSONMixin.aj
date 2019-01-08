// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Reviewer;
import pl.put.poznan.gamebase.web.GameDeserializer;
import pl.put.poznan.gamebase.web.ReviewJsonMixin;
import pl.put.poznan.gamebase.web.ReviewerDeserializer;

privileged aspect ReviewJsonMixin_Roo_JSONMixin {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @JsonDeserialize(using = GameDeserializer.class)
    private Game ReviewJsonMixin.game;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @JsonDeserialize(using = ReviewerDeserializer.class)
    private Reviewer ReviewJsonMixin.reviewer;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Game
     */
    public Game ReviewJsonMixin.getGame() {
        return game;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param game
     */
    public void ReviewJsonMixin.setGame(Game game) {
        this.game = game;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Reviewer
     */
    public Reviewer ReviewJsonMixin.getReviewer() {
        return reviewer;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewer
     */
    public void ReviewJsonMixin.setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
    
}