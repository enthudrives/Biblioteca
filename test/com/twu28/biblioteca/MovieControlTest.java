package com.twu28.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class MovieControlTest {

    @Test
    public void shouldListAllMovieNamesWithDirectorNamesAndRating()
    {
        MovieControl movieControl=new MovieControl();
        String expected=String.format("%20s\t%20s\t9/10\n","Titanic","James Cameron")
            +String.format("%20s\t%20s\t8/10\n","Casablanca", "Michael Curtiz")
            +String.format("%20s\t%20s\t8/10\n","Avatar","James Cameron")
            +String.format("%20s\t%20s\t7/10\n","Remember Me","Allen Coulter")
            +String.format("%20s\t%20s\tN/A\n","The Dark Knight Rises","Christopher Nolan");
        assertEquals(expected,movieControl.listMovies());
    }
}
