package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.*;


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
    public void shouldDisplayWelcomeMessageAndMenuTest()
    {
        String message=new MenuControl().welcomeMessage();
        Assert.assertTrue(message.contains("Welcome") && message.contains("Menu"));
    }

    @Test
    public void customerSelectsValidOptionFromMenuTest()
    {
        MenuControl menuControl=mock(MenuControl.class);
        when(menuControl.readChoice()).thenReturn(1);
        assertNotSame((new MenuControl().validateMenuOption(menuControl.readChoice())), 0);
        verify(menuControl).readChoice();
    }

    @Test
    public void customerSelectsInvalidOptionFromMenuTest()
    {
        MenuControl menuControl=mock(MenuControl.class);
        when(menuControl.readChoice()).thenReturn(5);
        assertEquals((new MenuControl().validateMenuOption(menuControl.readChoice())), 0);
        verify(menuControl).readChoice();
    }

    @Test
    public void shouldDisplyBookNamesWhenUserSelectsOneTest()
    {
        MenuControl menuControl = new MenuControl();
        MenuControl menuControlSpy = spy(menuControl);
        doReturn(1).when(menuControlSpy).readChoice();
        menuControlSpy.performActionBasedOnChoice(menuControlSpy.validateMenuOption(menuControlSpy.readChoice()));
        verify(menuControlSpy).displayAllBooksNames();
    }

    @Test
    public void shouldReserveBookWhenUserSelectsTwo()
    {
        MenuControl menuControl = new MenuControl();
        MenuControl menuControlSpy = spy(menuControl);
        doReturn(2).when(menuControlSpy).readChoice();
        doReturn(1).when(menuControlSpy).readISBN();
        menuControlSpy.performActionBasedOnChoice(menuControlSpy.validateMenuOption(menuControlSpy.readChoice()));
        menuControlSpy.performActionBasedOnChoice(menuControlSpy.validateMenuOption(menuControlSpy.readChoice()));
        verify(menuControlSpy,times(2)).reserveBook();
    }

    @Test
    public void shouldDisplayTalkToLibrarianWhenCheckLibraryNumberIsCalled()
    {
        MenuControl menuControl=new MenuControl();
        assertEquals(menuControl.checkLibraryNumber(), menuControl.talkToLibrarianMessage);
    }

    @Test
    public void shouldCheckLibraryNumberWhenUserSelectsThree()
    {
        MenuControl menuControl = new MenuControl();
        MenuControl menuControlSpy = spy(menuControl);
        doReturn(3).when(menuControlSpy).readChoice();
        menuControlSpy.performActionBasedOnChoice(menuControlSpy.validateMenuOption(menuControlSpy.readChoice()));
        verify(menuControlSpy).checkLibraryNumber();
    }
}
