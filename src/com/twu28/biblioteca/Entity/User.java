package com.twu28.biblioteca.Entity;

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
    private boolean loggedIn;

    public User(String uname, String pwd)
    {
        username=uname;
        password=pwd;
        loggedIn=false;
    }
    @Override
    public boolean equals(Object obj)
    {
        User user=(User)obj;
        if((user.username.equals(username))&&(user.password.equals(password)))
            return true;

            return false;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUserName() {
        return username;
    }
}
