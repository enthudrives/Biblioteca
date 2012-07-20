package com.twu28.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserControlTest
{
    @Test
    public void shouldCheckIfUserIsNotAuthenticatedWhenWrongUsernameIsEntered()
    {
        UserControl userControl=new UserControl();
        assertFalse(userControl.authenticate(new User("101-1111", "password")));
    }

    @Test
    public void shouldCheckIfUserIsNotAuthenticatedWhenWrongPasswordIsEntered()
    {
        UserControl userControl=new UserControl();
        assertFalse(userControl.authenticate(new User("111-1111", "passwd")));
    }

    @Test
    public void shouldCheckIfThePasswordMatchesWithTheUsername()
    {
        UserControl userControl=new UserControl();
        assertTrue(userControl.authenticate(new User("111-1111", "password")));
    }


}
