
/**
 * Write a description of FirstRatings here.
 * 
 * @author Kaiyi Huang
 * @version 1.0-3-27-2021
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;

public class FirstRatings {
    public ArrayList<Movie> loadMovies(String filename){
        FileResource Fr = new FileResource(filename);
        CSVParser csvParser = Fr.getCSVParser();
        ArrayList<Movie> result = new ArrayList<Movie>();
        for(CSVRecord csvR : csvParser){
            Movie newM = new Movie(csvR.get("id"), csvR.get("title"), csvR.get("year"), csvR.get("genre"), csvR.get("director"), csvR.get("country"), csvR.get("poster"), Integer.parseInt(csvR.get("minutes").trim()));
            result.add(newM);
        }
        return result;
    }
    
    public void testLoadMovies(){
        ArrayList<Movie> movies = loadMovies("data/ratedmoviesfull.csv");
        System.out.println("Number of movies in the list: " + movies.size());
        int countComedy = 0;
        for(Movie m : movies){
            if(m.getGenres ().contains("Comedy")){
                countComedy++;
            }
        }
        System.out.println("Number of Comedy movies in the list: " + countComedy);
        int countLength = 0;
        for(Movie m : movies){
            if(m.getMinutes() > 150){
                countLength++;
            }
        }
        System.out.println("Number of movies longer than 150 min in the list: " + countLength);
        HashMap<String, Integer> directors = new HashMap<String, Integer>();
        for(Movie m : movies){
            String directorcurr = m.getDirector();
            if(directors.containsKey(directorcurr)){
                int sizecurr = directors.get(directorcurr);
                directors.put(directorcurr, sizecurr + 1);
            }else{
                directors.put(directorcurr, 1);
            }
    }
    int directorLength = 0;    
    for(Integer i : directors.values()){
        if(i > directorLength) directorLength = i;
        }
    System.out.println("Max num of movies: " + directorLength);
        for(String s : directors.keySet()){
        if(directors.get(s) == directorLength){
            System.out.println("director's name: " + s);
        }      
    }
    }
    
    public ArrayList<EfficientRater> LoadRaters(String filename){
        FileResource Fr = new FileResource(filename);
        CSVParser csvParser = Fr.getCSVParser();
        ArrayList<EfficientRater> result = new ArrayList<EfficientRater>();
        for(CSVRecord csvR : csvParser){
            String raterid = csvR.get("rater_id");
            boolean RaterExist = false;
            int ExistIndex = 0;

            for(EfficientRater curr: result){
                if(curr.getID().equals(raterid)) {
                    RaterExist = true; 
                    ExistIndex = result.indexOf(curr);
                //System.out.println("RaterExist has been changed, the index is " + ExistIndex);
            }
            }
            if(RaterExist){
                result.get(ExistIndex).addRating(csvR.get("movie_id"), Double.parseDouble(csvR.get("rating")));
            }else{
                EfficientRater newRT = new EfficientRater(raterid);
                newRT.addRating(csvR.get("movie_id"), Double.parseDouble(csvR.get("rating")));
                result.add(newRT);
            }
            //System.out.println("Raterid: "+ result.get(0));
        }
        return result;
    }
    
    public void testLoadRaters(){
        ArrayList<EfficientRater> raters = LoadRaters("data/ratings.csv");
        System.out.println("Number of raters in the list: " + raters.size());
        int countComedy = 0;
        String specificRater = "193";
        int maxNumRatings = 0;
        String HighestNumRater = null;
        String MovieId = "1798709";
        int MovieNumRatings = 0 ;
        ArrayList<String> movies = new ArrayList<String>();
        for(EfficientRater eachR : raters){
            //System.out.println("id: " + eachR.getID() + " num of rating: "+ eachR.numRatings());
            //System.out.println(eachR.getItemsRated().toString());
            
            // find the number of ratings for a particular rater you specify in your code.
            if(eachR.getID().equals(specificRater)){
                System.out.println("Rater "+ specificRater + " has numRatings of: " + eachR.numRatings());
            }
            
            //find the maximum number of ratings by any rater
            if(eachR.numRatings() > maxNumRatings){
                maxNumRatings = eachR.numRatings();
                HighestNumRater = eachR.getID();
            }
            
            // find the number of ratings a particular movie has
            if(eachR.getRating(MovieId) >= 0){
                MovieNumRatings++;
            }
            
            //determine how many different movies have been rated by all these raters
            for(String currMovie: eachR.getItemsRated()){
                if(!movies.contains(currMovie)){movies.add(currMovie);}
            }
        }
        System.out.println("HighestNumRater is "+ HighestNumRater + " with maxNumRatings: " + maxNumRatings);
        System.out.println("Movie with ID:  "+ MovieId + " has the most num raters: " + MovieNumRatings);
        System.out.println("Total number of movies rated:  "+ movies.size() );

    }

}
