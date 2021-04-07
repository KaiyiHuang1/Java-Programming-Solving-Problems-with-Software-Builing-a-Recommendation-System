
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author Kaiyi Huang
 * @version 1.0-3-27-2021
 */

import java.util.*;

public class MovieRunnerAverage {
    private String moviesFile;
    private String ratersFile;
    public MovieRunnerAverage(){
        moviesFile = "data/ratedmovies_short.csv";
        ratersFile = "data/ratings_short.csv";
    }
    
    public void printAverageRatings(){
        SecondRatings SR = new SecondRatings(moviesFile, ratersFile);
        System.out.println("MRA Number of movies in the list: " + SR.getMovieSize());
        System.out.println("MRA Number of raters in the list: " + SR.getRaterSize());
        int minimlRaters = 3;
        ArrayList<Rating> all = SR.getAverageRatings(minimlRaters);
        for(Rating r: all){
            System.out.println(r.getValue()+"\t"+SR.getTitle(r.getItem()));
        }
    }
    
    public void getAverageRatingOneMovie(){
        SecondRatings SR = new SecondRatings(moviesFile, ratersFile);
        String title = "The Godfather";
        String ID = SR.getID(title);
        double AveRating =SR.getAverageByID(ID, 0);
        System.out.println(AveRating+"\t"+ title);
    }

}
