package com.twu28.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookControl {

    ArrayList<Book> books =new ArrayList<Book>();

    public void createBooks() {
        books.add(new Book(1, "Eat, Pray, Love", "Elizabeth Gilbert"));
        books.add(new Book(2, "One moment", "McBride Kristina"));
        books.add(new Book(3, "The power of Habit", "Duhigg Charles"));
    }

    public String reserveBook(int id, String successMessage, String failureMessage)
    {
        int bookIndex=id-1;
        if(id<=books.size())
        {
            if(books.get(bookIndex).isAvailable())
            {
                books.get(bookIndex).setAvailable(false);
                return successMessage;
            }
        }
        return  failureMessage;
    }

    public String getBooksNames() {
        String booklist="";
        for(Book book: books)
        {
            booklist+=book.toString()+"\n";
        }
        return booklist;
    }
}