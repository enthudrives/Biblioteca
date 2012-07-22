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
        when(menuControl.readChoice()).thenReturn(6);
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
    public void shouldCheckIfUserIsLoggedInBeforeReservingBook()
    {
        MenuControl menuControl=new MenuControl();
        User user=mock(User.class);
        menuControl.setCurrentUser(user);
        menuControl.performActionBasedOnChoice(2);
        verify(user).isLoggedIn();
    }

    @Test
    public void shouldCallReserveBookWhenUserSelectsTwo()
    {
        MenuControl menuControl=new MenuControl();
        MenuControl menuControlSpy=spy(menuControl);
        User user=new User("guest","");
        user.setLoggedIn(true);
        menuControlSpy.setCurrentUser(user);

        doReturn(1).when(menuControlSpy).readChoice();

        BookControl bookControl=mock(BookControl.class);
        menuControlSpy.setBookControl(bookControl);

        menuControlSpy.performActionBasedOnChoice(2);
        verify(bookControl).reserveBook(1, menuControlSpy.successMessage, menuControlSpy.failureMessage);
    }


    @Test
    public void shouldCheckIfUserIsLoggedInBeforeCheckingLibraryNumber() {
        MenuControl menuControl=new MenuControl();
        User user=mock(User.class);
        menuControl.setCurrentUser(user);
        menuControl.performActionBasedOnChoice(3);
        verify(user).isLoggedIn();
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
    public void shouldDisplayUsersLibraryNumberIfLoggedInWhenCheckLibraryNumberIsCalled()
    {
        MenuControl menuControl=new MenuControl();
        User user=new User("guest","");
        user.setLoggedIn(true);
        menuControl.setCurrentUser(user);
        assertEquals("guest",menuControl.checkLibraryNumber());
    }

    @Test
    public void shouldDisplayTalkToLibrarianIfNotLoggedInWhenCheckLibraryNumberIsCalled()
    {
        MenuControl menuControl=new MenuControl();
        assertEquals(menuControl.talkToLibrarianMessage,menuControl.checkLibraryNumber());
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
