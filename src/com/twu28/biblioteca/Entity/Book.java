package com.twu28.biblioteca.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book extends Entity {

    String author;

    public Book(int number, String name, String auth) {
        id =number;
        title=name;
        author=auth;
        available=true;
    }
    @Override
    public String toString()
    {
        return id + ". " + title + ", by " + author;
    }
}
