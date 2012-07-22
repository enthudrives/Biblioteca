package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    UserControl userControl;
    @Before
    public void setUp() throws Exception {
        userControl=new UserControl();
    }

    @Test
    public void shouldCheckIfUserIsNotAuthenticatedWhenWrongUsernameIsEntered()
    {
        assertFalse(userControl.authenticate(new User("101-1111", "password")));
    }

    @Test
    public void shouldCheckIfUserIsNotAuthenticatedWhenWrongPasswordIsEntered()
    {
        assertFalse(userControl.authenticate(new User("111-1111", "passwd")));
    }

    @Test
    public void shouldCheckIfThePasswordMatchesWithTheUsername()
    {
        assertTrue(userControl.authenticate(new User("111-1111", "password")));
    }

}
