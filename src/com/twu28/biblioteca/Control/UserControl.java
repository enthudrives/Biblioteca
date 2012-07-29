package com.twu28.biblioteca.Control;

import com.twu28.biblioteca.Entity.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/21/12
 * Time: 2:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserControl
{
   // User currentUser=null;
    ArrayList<User> users=new ArrayList<User>();
    public UserControl()
    {
        createUsers();
    }

    protected void createUsers() {
        addUser(new User("111-1111","password"));
        addUser(new User("111-1112","password"));
        addUser(new User("111-1113","password"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Boolean authenticate(User user) {
        Boolean status=false;
        for(User user1:users)
        {
            if(user.equals(user1))
                {
                    user.setLoggedIn(true);
                    status=true;
                    break;
                }
        }
        return status;
    }
}
