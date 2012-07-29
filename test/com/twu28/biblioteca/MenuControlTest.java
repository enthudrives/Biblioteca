package com.twu28.biblioteca;

import com.twu28.biblioteca.Entity.User;
import com.twu28.biblioteca.Control.BookControl;
import com.twu28.biblioteca.Control.MenuControl;
import com.twu28.biblioteca.Control.MovieControl;
import com.twu28.biblioteca.Control.UserControl;
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
        assertEquals((menuControl.validateMenuOption(menuControl.readChoice())), 0);
        verify(menuControl).readChoice();
    }

    @Test
    public void shouldCallDisplayBookNamesWhenUserSelectsOneTest()
    {
        menuControl=spy(menuControl);
        BookControl bookControl=new BookControl();
        menuControl.setBookControl(bookControl);
        menuControl.performActionBasedOnChoice(1);
        verify(menuControl).displayAllBooksNames();
    }

    @Test
    public void shouldNotCallReserveBookWhenUserIsNotLoggedIn()
    {
        menuControl=mock(MenuControl.class);
        doCallRealMethod().when(menuControl).performActionBasedOnChoice(2);
        menuControl.performActionBasedOnChoice(2);
        verify(menuControl, never()).reserveBook();
    }

    @Test
    public void shouldCallReserveBookWhenUserSelectsTwoIfLoggedIn()
    {
        MenuControl menuControlSpy=spy(menuControl);
        menuControlSpy.setCurrentUser(new User("100-1000",""));
        BookControl bookControl=mock(BookControl.class);
        menuControlSpy.setBookControl(bookControl);
        doReturn(1).when(menuControlSpy).readChoice();
        menuControlSpy.performActionBasedOnChoice(2);
        verify(bookControl).reserveBook(1);
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
        User user=new User("100-1000","");
        menuControl.setCurrentUser(user);
        assertEquals("100-1000",menuControl.checkLibraryNumber());
    }

    @Test
    public void shouldDisplayTalkToLibrarianIfNotLoggedInWhenCheckLibraryNumberIsCalled()
    {
        assertEquals(MenuControl.TALK_TO_LIBRARIAN_MESSAGE,menuControl.checkLibraryNumber());
    }

    @Test
    public void shouldCallDisplayAllMovieNamesWhenUserSelectsFourTest()
    {
        menuControl=spy(menuControl);
        MovieControl movieControl=new MovieControl();
        menuControl.setMovieControl(movieControl);
        menuControl.performActionBasedOnChoice(4);
        verify(menuControl).displayAllMovieNames();
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
