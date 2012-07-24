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
        bookControl.insertIntoList(new Book(1,"book1","author1"));
        bookControl.insertIntoList(new Book(2,"book2","author2"));
        bookControl.insertIntoList(new Book(3,"book3","author3"));
    }

    @Test
    public void testIfAllBookNamesAreReturned()
    {
        String expected="1. book1, by author1\n2. book2, by author2\n3. book3, by author3\n";
        Assert.assertEquals(bookControl.getList(), expected);
    }
    
    @Test
    public void testIfSuccessMessageIsReturnedWhenBookIsReservedSuccessfully()
    {
        Assert.assertEquals(bookControl.reserveBook(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE),MenuControl.SUCCESS_MESSAGE);
    }

    @Test
    public void testIfFailureMessageIsReturnedWhenBookIsNotAvailable()
    {
        bookControl.reserveBook(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE);
        Assert.assertEquals(bookControl.reserveBook(3, MenuControl.SUCCESS_MESSAGE, MenuControl.FAILURE_MESSAGE), MenuControl.FAILURE_MESSAGE);
    }

}
