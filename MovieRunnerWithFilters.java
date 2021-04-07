
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MovieRunnerWithFilters {
    
    private String ratersFile;
    
    public MovieRunnerWithFilters(){
        ratersFile = "data/ratings_short.csv";
    }
    
    public void printAverageRatings(){
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatings(minimlRaters);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle);
        }
        System.out.println("Number of movies in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByYear(){
        YearAfterFilter YF = new YearAfterFilter(2000);
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, YF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle);
        }
        System.out.println("Number of movies WITH YEAR FILTER in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByGenre(){
        GenreFilter GF = new GenreFilter("Crime");
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, GF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle +"\n"
                                                   +"\t"+MovieDatabase.getGenres(item));
        }
        System.out.println("Number of movies WITH GENRE FILTER in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByMinutes(){
        MinutesFilter MF = new MinutesFilter(110, 170);
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, MF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle +" Time:"+MovieDatabase.getMinutes(item));
        }
        System.out.println("Number of movies WITH MINUTES FILTER in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByDirectors(){
        DirectorsFilter DF = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, DF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle +" Time:"+MovieDatabase.getDirector(item));
        }
        System.out.println("Number of movies WITH DIRECTOR FILTER in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        AllFilters AF = new AllFilters();
        YearAfterFilter YF = new YearAfterFilter(1980);
        GenreFilter GF = new GenreFilter("Romance");
        AF.addFilter(YF);
        AF.addFilter(GF);
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, AF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle +" Year:"+MovieDatabase.getYear(item) + " Genres:" + MovieDatabase.getGenres(item));
        }
        System.out.println("Number of movies WITH YEAR AND GENRE FILTER in the file: "+ filemovies.size());

    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        AllFilters AF = new AllFilters();
        MinutesFilter MF = new MinutesFilter(30, 170);
        DirectorsFilter DF = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        AF.addFilter(MF);
        AF.addFilter(DF);
        ThirdRatings TR = new ThirdRatings(ratersFile);
        System.out.println("MRF Number of raters in the list: " + TR.getRaterSize());
        int minimlRaters = 1;
        ArrayList<Rating> all = TR.getAverageRatingsByFilter(minimlRaters, AF);
        ArrayList<String> allmovies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the database: " + allmovies.size());
        ArrayList<String> filemovies = new ArrayList<String>();
        for(Rating r : all){
             String item = r.getItem();
             String movieTitle = MovieDatabase.getTitle(item);
             if(!filemovies.contains(movieTitle)){filemovies.add(movieTitle);}
             System.out.println((double)Math.round(r.getValue() * 10000d) / 10000d+ 
                                                   " " + movieTitle +" Minutes:"+MovieDatabase.getMinutes(item) + " Director:" + MovieDatabase.getDirector(item));
        }
        System.out.println("Number of movies WITH DIRECTOR AND MINUTES FILTER in the file: "+ filemovies.size());

    }


}
