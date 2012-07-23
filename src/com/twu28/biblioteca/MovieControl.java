package com.twu28.biblioteca;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MovieControl extends EntityControl{
    public MovieControl()
    {
            list.add(new Movie(1, "Titanic", "James Cameron", 9));
            list.add(new Movie(2, "Casablanca", "Michael Curtiz", 8));
            list.add(new Movie(3, "Avatar", "James Cameron", 8));
            list.add(new Movie(4, "Remember Me", "Allen Coulter", 7));
            list.add(new Movie(5, "The Dark Knight Rises", "Christopher Nolan"));
    }
}
