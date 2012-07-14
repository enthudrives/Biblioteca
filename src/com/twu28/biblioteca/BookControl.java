package com.twu28.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControl {

    Map<Integer, Book> book= new HashMap<Integer, Book>();  //Using ISDN as key to store books

    public void createBooks() {
        book.put(1,new Book(1,"Eat, Pray, Love", "Elizabeth Gilbert"));
        book.put(2,new Book(2,"One moment","McBride Kristina"));
        book.put(3,new Book(3,"The power of Habit","Duhigg Charles"));
    }

    public String reserveBook(int isdn)
    {
        String message= "Sorry we don't have that book yet.";
        if(book.containsKey(isdn))         //If that book exists in our library
        {
            if(book.get(isdn).isAvailable())     //If it is currently available
            {
                book.get(isdn).setAvailable(false);
                message="Thank You! Enjoy the Book.";
            }
        }
        return  message;
    }

    public String getBooks() {
        String booklist="";
        for(Book b:book.values())
        {
            booklist+=b.toString()+"\n";
        }
        return booklist;
    }
}