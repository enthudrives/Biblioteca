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
        movieControl.insertIntoList(new Movie(1,"movie1", "director1",8));
        movieControl.insertIntoList(new Movie(2,"movie2", "director2",7));
        movieControl.insertIntoList(new Movie(3,"movie3", "director3"));
        String expected="1. movie1, by director1 Rating:8\n" +"2. movie2, by director2 Rating:7\n"
                +"3. movie3, by director3 Rating:N/A\n";
        assertEquals(expected,movieControl.getList());
    }
}
