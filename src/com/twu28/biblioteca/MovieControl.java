package com.twu28.biblioteca;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MovieControl {
    ArrayList<Movie> movies=new ArrayList<Movie>();

    public MovieControl()
    {
            movies.add(new Movie("Titanic", "James Cameron",9 ));
            movies.add(new Movie("Casablanca", "Michael Curtiz",8 ));
            movies.add(new Movie("Avatar", "James Cameron",8 ));
            movies.add(new Movie("Remember Me", "Allen Coulter",7));
            movies.add(new Movie("The Dark Knight Rises", "Christopher Nolan"));
    }

    public String listMovies()
    {
        String movielist="";
        for(Movie movie:movies)
            movielist+=movie.toString()+"\n";
        return movielist;
    }
}
