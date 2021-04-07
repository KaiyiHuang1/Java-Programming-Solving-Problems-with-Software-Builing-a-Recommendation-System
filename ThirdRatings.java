
/**
 * Write a description of ThirdRatings here.
 * 
 * @author Kaiyi Huang
 * @version 1.0-3-27-2021
 */
import java.util.*;


public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile) {
        FirstRatings R1 = new FirstRatings();
        myRaters = R1.LoadRaters(ratingsfile);
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    public double getAverageByID(String id, int minimlRaters){
        int numRaters = 0;
        double totalRating = 0;
        for(EfficientRater eachR : myRaters){
            if(eachR.getRating(id) >= 0){
                numRaters++;
                totalRating += eachR.getRating(id);
            }
        }
        if(numRaters >= minimlRaters){
            return totalRating/numRaters;
        }else{
            return 0.0;
        }
    }
    
    public ArrayList<Rating> getAverageRatings(int minimlRaters){
        ArrayList<Rating> result = new ArrayList<Rating>();
        ArrayList<String> moviesScanned =  new ArrayList<String>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        double AverageByID = 0.0;
            for(String currMovie: movies){
                if(!moviesScanned.contains(currMovie)){
                    moviesScanned.add(currMovie);
                    AverageByID = getAverageByID(currMovie,minimlRaters);
                    if(AverageByID > 0){
                    Rating newRating = new Rating(currMovie,AverageByID);
                    result.add(newRating);
                    }
                }
            }
        
        return result;
    }
    
        
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<String> allmovies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> result = new ArrayList<Rating>();
        for(String movie : allmovies){
            double aveRating = getAverageByID(movie,minimalRaters);
            if(aveRating > 0){
              Rating newRating = new Rating(movie,aveRating);
              result.add(newRating);
            }
        }
        return result;
    }
    

}
