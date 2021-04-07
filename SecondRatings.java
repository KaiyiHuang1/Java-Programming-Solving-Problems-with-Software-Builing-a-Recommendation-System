/**
 * Write a description of SecondRatings here.
 * 
 * @author Kaiyi Huang
 * @version 1.0-3-27-2021
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings R1 = new FirstRatings();
        myMovies = R1.loadMovies(moviefile);
        myRaters = R1.LoadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
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
        double AverageByID = 0.0;
        for(EfficientRater eachR : myRaters){
            for(String currMovie: eachR.getItemsRated()){
                if(!moviesScanned.contains(currMovie)){
                    moviesScanned.add(currMovie);
                    AverageByID = getAverageByID(currMovie,minimlRaters);
                    if(AverageByID > 0){
                    Rating newRating = new Rating(currMovie,AverageByID);
                    result.add(newRating);
                    }
                }
            }
        }
        
        return result;
    }
    
    public String getTitle(String id){
        String error = "ID was not found";
        boolean idFound = false;
        String returnTitle =  null;
        for(Movie currMV : myMovies){
            if(currMV.getID ().equals(id)){
                idFound = true;
                returnTitle =  currMV.getTitle ();
                break;
            }
        }
        if(!idFound){
            return error;
        }else{
            return returnTitle;
        }
    }
    
    public String getID(String title){
        String error = "NO SUCH TITLE.";
        boolean titleFound = false;
        String returnID =  null;
        for(Movie currMV : myMovies){
            if(currMV.getTitle ().equals(title)){
                titleFound = true;
                returnID =  currMV.getID ();
                break;
            }
        }
        if(!titleFound){
            return error;
        }else{
            return returnID;
        }
    }
}
