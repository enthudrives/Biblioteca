package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControlTest {
    @Test
    public void viewAllBooksTest()
    {
        BookControl b=new BookControl();
        b.createBooks();
        String expected="1. Eat, Pray, Love, by Elizabeth Gilbert\n2. One moment, by McBride Kristina\n3. The power of Habit, by Duhigg Charles\n";
        Assert.assertEquals(b.getBooks(), expected);
    }
    @Test
    public void reserveBookTest()
    {
        BookControl b=new BookControl();
        b.createBooks();
        Assert.assertEquals(b.reserveBook(3),"Thank You! Enjoy the Book.");
        Assert.assertEquals(b.reserveBook(3),"Sorry we don't have that book yet.");
    }

}
