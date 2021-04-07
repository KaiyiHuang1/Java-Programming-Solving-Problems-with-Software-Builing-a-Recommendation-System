
/**
 * Write a description of Rater here.
 * 
 * @Kaiyi Huang
 * @version 1
 */

import java.util.*;

public interface Rater {
    
    public void addRating(String item, double rating); 

    public boolean hasRating(String item);

    public String getID() ;

    public double getRating(String item) ;
    
    public int numRatings() ;
    
    public ArrayList<String> getItemsRated() ;
}
