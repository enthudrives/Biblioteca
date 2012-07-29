package com.twu28.biblioteca.Control;

import com.twu28.biblioteca.Entity.Book;
import com.twu28.biblioteca.Entity.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControl extends EntityControl{

    protected void createBooks() {
        insertIntoList(new Book(1, "Eat, Pray, Love", "Elizabeth Gilbert"));
        insertIntoList(new Book(2, "One moment", "McBride Kristina"));
        insertIntoList(new Book(3, "The power of Habit", "Duhigg Charles"));
    }

    public boolean reserveBook(int id)
    {
        int index=id-1;
        if(id<= list.size())
        {
            Entity entity = list.get(index);
            if(entity.isAvailable())
            {
                entity.setAvailable(false);
                return true;
            }
        }
        return  true;
    }

}