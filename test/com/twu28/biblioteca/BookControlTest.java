package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;


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
        Assert.assertEquals(b.getBooksNames(), expected);
    }
    @Test
    public void reserveBookTest()
    {
        BookControl b=new BookControl();
        b.createBooks();
        MenuControl menuControl=new MenuControl();
        Assert.assertEquals(b.reserveBook(3, menuControl.successMessage, menuControl.failureMessage),menuControl.successMessage);
        Assert.assertEquals(b.reserveBook(3, menuControl.successMessage, menuControl.failureMessage), menuControl.failureMessage);
    }

}
