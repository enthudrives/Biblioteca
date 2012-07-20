package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Movie
{
    String name,director;
    int rating;

    public Movie(String title,String director)
    {
        this(title,director,0);
    }

    public Movie(String title,String director,int rating)
    {
        this.name=title;
        this.director=director;
        this.rating=rating;
    }

    @Override
    public String toString()
    {
        return String.format(("%20s\t%20s\t"),name,director) + ((rating!=0)?(String.format("%d/10",rating)):("N/A"));
    }
}
