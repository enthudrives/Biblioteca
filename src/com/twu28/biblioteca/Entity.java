package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/23/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entity
{
    protected int id;
    protected String title;
    protected boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean b) {
        available=b;
    }
}
