// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.structures;

import java.util.Objects;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.structures.Reviewer;

privileged aspect Review_Roo_JavaBean {
    
    /**
     * Gets id value
     * 
     * @return Long
     */
    public Long Review.getId() {
        return this.id;
    }
    
    /**
     * Sets id value
     * 
     * @param id
     * @return Review
     */
    public Review Review.setId(Long id) {
        this.id = id;
        return this;
    }
    
    /**
     * Gets version value
     * 
     * @return Integer
     */
    public Integer Review.getVersion() {
        return this.version;
    }
    
    /**
     * Sets version value
     * 
     * @param version
     * @return Review
     */
    public Review Review.setVersion(Integer version) {
        this.version = version;
        return this;
    }
    
    /**
     * Gets reviewer value
     * 
     * @return Reviewer
     */
    public Reviewer Review.getReviewer() {
        return this.reviewer;
    }
    
    /**
     * Sets reviewer value
     * 
     * @param reviewer
     * @return Review
     */
    public Review Review.setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
        return this;
    }
    
    /**
     * Gets user_score value
     * 
     * @return Float
     */
    public Float Review.getUser_score() {
        return this.user_score;
    }
    
    /**
     * Sets user_score value
     * 
     * @param user_score
     * @return Review
     */
    public Review Review.setUser_score(Float user_score) {
        this.user_score = user_score;
        return this;
    }
    
    /**
     * Gets crit_score value
     * 
     * @return Float
     */
    public Float Review.getCrit_score() {
        return this.crit_score;
    }
    
    /**
     * Sets crit_score value
     * 
     * @param crit_score
     * @return Review
     */
    public Review Review.setCrit_score(Float crit_score) {
        this.crit_score = crit_score;
        return this;
    }
    
    /**
     * Gets gameplay value
     * 
     * @return Float
     */
    public Float Review.getGameplay() {
        return this.gameplay;
    }
    
    /**
     * Sets gameplay value
     * 
     * @param gameplay
     * @return Review
     */
    public Review Review.setGameplay(Float gameplay) {
        this.gameplay = gameplay;
        return this;
    }
    
    /**
     * Gets graphics value
     * 
     * @return Float
     */
    public Float Review.getGraphics() {
        return this.graphics;
    }
    
    /**
     * Sets graphics value
     * 
     * @param graphics
     * @return Review
     */
    public Review Review.setGraphics(Float graphics) {
        this.graphics = graphics;
        return this;
    }
    
    /**
     * Gets audio value
     * 
     * @return Float
     */
    public Float Review.getAudio() {
        return this.audio;
    }
    
    /**
     * Sets audio value
     * 
     * @param audio
     * @return Review
     */
    public Review Review.setAudio(Float audio) {
        this.audio = audio;
        return this;
    }
    
    /**
     * Gets game value
     * 
     * @return Game
     */
    public Game Review.getGame() {
        return this.game;
    }
    
    /**
     * Sets game value
     * 
     * @param game
     * @return Review
     */
    public Review Review.setGame(Game game) {
        this.game = game;
        return this;
    }
    
    /**
     * This `equals` implementation is specific for JPA entities and uses 
     * the entity identifier for it, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @param obj
     * @return Boolean
     */
    public boolean Review.equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Review)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Review) obj).getId());
    }
    
    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able 
     * to identify the entity in collections after a new id is assigned to the entity, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @return Integer
     */
    public int Review.hashCode() {
        return 31;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String Review.toString() {
        return "Review {" + 
                "id='" + id + '\'' + 
                ", version='" + version + '\'' + 
                ", user_score='" + user_score + '\'' + 
                ", crit_score='" + crit_score + '\'' + 
                ", gameplay='" + gameplay + '\'' + 
                ", graphics='" + graphics + '\'' + 
                ", audio='" + audio + '\'' + "}" + super.toString();
    }
    
}