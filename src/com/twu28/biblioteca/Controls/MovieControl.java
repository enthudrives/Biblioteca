package com.twu28.biblioteca.Controls;
import com.twu28.biblioteca.Components.Movie;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MovieControl extends EntityControl{

    protected void createMovies() {
        insertIntoList(new Movie(1, "Titanic", "James Cameron", 9));
        insertIntoList(new Movie(2, "Casablanca", "Michael Curtiz", 8));
        insertIntoList(new Movie(3, "Avatar", "James Cameron", 8));
        insertIntoList(new Movie(4, "Remember Me", "Allen Coulter", 7));
        insertIntoList(new Movie(5, "The Dark Knight Rises", "Christopher Nolan"));
    }
}
