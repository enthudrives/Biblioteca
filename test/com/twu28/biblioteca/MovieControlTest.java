package com.twu28.biblioteca;
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
        String expected="1. Titanic, by James Cameron Rating:9\n" +
                "2. Casablanca, by Michael Curtiz Rating:8\n" +
                "3. Avatar, by James Cameron Rating:8\n" +
                "4. Remember Me, by Allen Coulter Rating:7\n" +
                "5. The Dark Knight Rises, by Christopher Nolan Rating:N/A\n";
        assertEquals(expected,movieControl.getList());
    }
}
