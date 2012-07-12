package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuControlTest
{
    @Test
    public void displayWelcomeMessageTest()
    {
        Assert.assertTrue(MenuControl.welcomeMessage().contains("Welcome"));
    }
    @Test
    public void displayMenuTest()
    {
        Assert.assertTrue(MenuControl.welcomeMessage().contains("Menu"));
    }
    @Test
    public void customerSelectsValidOptionFromMenuTest()
    {
        int option=5; //Change value to test
        int expected=option;
        if((option<1)||(option>4))
            expected=0; //If option is invalid, 0 is returned.
        assertEquals(MenuControl.selectMenuOption(option), expected);
    }
}
