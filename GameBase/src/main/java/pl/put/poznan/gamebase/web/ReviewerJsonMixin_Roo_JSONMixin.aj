// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.web.ReviewerJsonMixin;

privileged aspect ReviewerJsonMixin_Roo_JSONMixin {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @JsonIgnore
    private Set<Review> ReviewerJsonMixin.reviews;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Set
     */
    public Set<Review> ReviewerJsonMixin.getReviews() {
        return reviews;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviews
     */
    public void ReviewerJsonMixin.setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
    
}
