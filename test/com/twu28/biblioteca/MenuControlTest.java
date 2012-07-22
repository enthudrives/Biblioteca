package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
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
    MenuControl menuControl;

    @Before
    public void setUp() throws Exception {
          menuControl=new MenuControl();
    }

    @Test
    public void shouldDisplayWelcomeMessageAndMenuTest()
    {
        String message=menuControl.welcomeMessage();
        Assert.assertTrue(message.contains("Welcome") && message.contains("Menu"));
    }

    @Test
    public void customerSelectsValidOptionFromMenuTest()
    {
        menuControl=mock(MenuControl.class);
        when(menuControl.readChoice()).thenReturn(1);
        assertNotSame((new MenuControl().validateMenuOption(menuControl.readChoice())), 0);
        verify(menuControl).readChoice();
    }

    @Test
    public void customerSelectsInvalidOptionFromMenuTest()
    {
        menuControl=mock(MenuControl.class);
        when(menuControl.readChoice()).thenReturn(6);
        assertEquals((new MenuControl().validateMenuOption(menuControl.readChoice())), 0);
        verify(menuControl).readChoice();
    }

    @Test
    public void shouldCallDisplayBookNamesWhenUserSelectsOneTest()
    {
        BookControl bookControl=mock(BookControl.class);
        menuControl.setBookControl(bookControl);

        menuControl.performActionBasedOnChoice(1);
        verify(bookControl).getBooksNames();
    }

    @Test
    public void shouldCheckIfUserIsLoggedInBeforeReservingBook()
    {
        User user=mock(User.class);
        menuControl.setCurrentUser(user);
        menuControl.performActionBasedOnChoice(2);
        verify(user).isLoggedIn();
    }

    @Test
    public void shouldCallReserveBookWhenUserSelectsTwo()
    {
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
    public void shouldCheckIfUserIsLoggedInBeforeCheckingLibraryNumber()
    {
        User user=mock(User.class);
        menuControl.setCurrentUser(user);
        menuControl.performActionBasedOnChoice(3);
        verify(user).isLoggedIn();
    }

    @Test
    public void shouldCallCheckLibraryNumberWhenUserSelectsThree()
    {
        menuControl=mock(MenuControl.class);

        doCallRealMethod().when(menuControl).performActionBasedOnChoice(3);

        menuControl.performActionBasedOnChoice(3);
        verify(menuControl).checkLibraryNumber();
    }

    @Test
    public void shouldDisplayUsersLibraryNumberIfLoggedInWhenCheckLibraryNumberIsCalled()
    {
        User user=new User("111-0000","");
        user.setLoggedIn(true);
        menuControl.setCurrentUser(user);
        assertEquals("111-0000",menuControl.checkLibraryNumber());
    }

    @Test
    public void shouldDisplayTalkToLibrarianIfNotLoggedInWhenCheckLibraryNumberIsCalled()
    {
        assertEquals(menuControl.talkToLibrarianMessage,menuControl.checkLibraryNumber());
    }

    @Test
    public void shouldCallDisplayAllMovieNamesWhenUserSelectsFourTest()
    {
        MovieControl movieControl=mock(MovieControl.class);
        menuControl.setMovieControl(movieControl);

        menuControl.performActionBasedOnChoice(4);
        verify(movieControl).listMovies();
    }

    @Test
    public void shouldAuthenticateUserWhenUserSelectsFive()
    {
        MenuControl menuControlSpy=spy(menuControl);

        UserControl userControl=mock(UserControl.class);
        menuControlSpy.setUserControl(userControl);

        User user=new User("111-1111","password");
        doReturn(user).when(menuControlSpy).readUser();
        menuControlSpy.performActionBasedOnChoice(5);
        verify(userControl).authenticate(user);
    }

}
