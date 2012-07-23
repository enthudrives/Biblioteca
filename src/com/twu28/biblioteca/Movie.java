package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Movie extends Entity
{
    String director;
    int rating;

    public Movie(int id,String title,String director)
    {
        this(id,title,director,0);
    }

    public Movie(int id,String title,String director,int rating)
    {
        this.id=id;
        this.title =title;
        this.director=director;
        this.rating=rating;
    }

    @Override
    public String toString()
    {
        return id + ". " + title + ", by " + director+" Rating:"+ ((rating!=0)?(rating):("N/A"));
    }
}
