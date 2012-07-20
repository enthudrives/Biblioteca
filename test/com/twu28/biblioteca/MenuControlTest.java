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
    public void shouldCallDisplayBookNamesWhenUserSelectsOneTest()
    {
        MenuControl menuControl=new MenuControl();
        BookControl bookControl=mock(BookControl.class);
        menuControl.setBookControl(bookControl);

        menuControl.performActionBasedOnChoice(1);
        verify(bookControl).getBooksNames();
    }

    @Test
    public void shouldCallReserveBookWhenUserSelectsTwo()
    {
        MenuControl menuControl=new MenuControl();
        MenuControl menuControlSpy=spy(menuControl);
        doReturn(1).when(menuControlSpy).readChoice();

        BookControl bookControl=mock(BookControl.class);
        menuControlSpy.setBookControl(bookControl);

        menuControlSpy.performActionBasedOnChoice(2);
        verify(bookControl).reserveBook(1, menuControlSpy.successMessage, menuControlSpy.failureMessage);
    }

    @Test
    public void shouldDisplayTalkToLibrarianIfUserIsNotLoggedInWhenCheckLibraryNumberIsCalled()
    {
        MenuControl menuControl=new MenuControl();
        assertEquals(menuControl.checkLibraryNumber(), menuControl.talkToLibrarianMessage);
    }

    @Test
    public void shouldDisplayUsersLibraryNumberIfLoggedInWhenCheckLibraryNumberIsCalled()
    {
        MenuControl menuControl=new MenuControl();
        UserControl userControl=new UserControl();
        userControl.authenticate(new User("111-1111","password"));
        menuControl.setUserControl(userControl);

        assertEquals("111-1111",menuControl.checkLibraryNumber());
    }
    @Test
    public void shouldCallCheckLibraryNumberWhenUserSelectsThree()
    {
        MenuControl menuControl=mock(MenuControl.class);

        doCallRealMethod().when(menuControl).performActionBasedOnChoice(3);

        menuControl.performActionBasedOnChoice(3);
        verify(menuControl).checkLibraryNumber();
    }

    @Test
    public void shouldCallDisplayAllMovieNamesWhenUserSelectsFourTest()
    {
        MenuControl menuControl=new MenuControl();
        MovieControl movieControl=mock(MovieControl.class);
        menuControl.setMovieControl(movieControl);

        menuControl.performActionBasedOnChoice(4);
        verify(movieControl).listMovies();
    }
    @Test
    public void shouldAuthenticateUserWhenUserSelectsFive()
    {
        MenuControl menuControl=new MenuControl();
        MenuControl menuControlSpy=spy(menuControl);

        UserControl userControl=mock(UserControl.class);
        menuControlSpy.setUserControl(userControl);

        User user=new User("111-1111","password");
        doReturn(user).when(menuControlSpy).readUser();
        menuControlSpy.performActionBasedOnChoice(5);
        verify(userControl).authenticate(user);
    }
}
