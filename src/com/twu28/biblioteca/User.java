package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class User
{
    String username, password;
    public User(String uname, String pwd)
    {
        username=uname;
        password=pwd;
    }
    @Override
    public boolean equals(Object obj)
    {
        User user=(User)obj;
        if((user.username.equals(username))&&(user.password.equals(password)))
            return true;

            return false;
    }
    @Override
    public String toString()
    {
        return username+" "+password;
    }
}
