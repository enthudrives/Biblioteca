package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    int id;
    String title, author;
    Boolean available;


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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean b) {
        available=b;
    }
}
