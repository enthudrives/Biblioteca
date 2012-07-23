package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControlTest {
    BookControl bookControl;
    @Before
    public void setUp() throws Exception {
         bookControl=new BookControl();
    }

    @Test
    public void testIfAllBookNamesAreReturned()
    {
        String expected="1. Eat, Pray, Love, by Elizabeth Gilbert\n2. One moment, by McBride Kristina\n3. The power of Habit, by Duhigg Charles\n";
        Assert.assertEquals(bookControl.getList(), expected);
    }
    
    @Test
    public void testIfSuccessMessageIsReturnedWhenBookIsReservedSuccessfully()
    {
        Assert.assertEquals(bookControl.reserve(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE),MenuControl.SUCCESS_MESSAGE);
    }

    @Test
    public void testIfFailureMessageIsReturnedWhenBookIsNotAvailable()
    {
        bookControl.reserve(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE);
        Assert.assertEquals(bookControl.reserve(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE), MenuControl.FAILURE_MESSAGE);
    }

}
