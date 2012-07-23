package com.twu28.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControl extends EntityControl{
    public BookControl()
    {
        list.add(new Book(1, "Eat, Pray, Love", "Elizabeth Gilbert"));
        list.add(new Book(2, "One moment", "McBride Kristina"));
        list.add(new Book(3, "The power of Habit", "Duhigg Charles"));
    }
    public String reserve(int id, String successMessage, String failureMessage)
    {
        int index=id-1;
        if(id<= list.size())
        {
            Entity entity = list.get(index);
            if(entity.isAvailable())
            {
                entity.setAvailable(false);
                return successMessage;
            }
        }
        return  failureMessage;
    }

}