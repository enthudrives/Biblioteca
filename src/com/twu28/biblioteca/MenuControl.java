package com.twu28.biblioteca;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */

/*
Load the screen
perform action based on choice
when user enters 1,
when user enters 2, reservebook() is called..
When user enters 3,
*/
public class MenuControl {
    BookControl bookControl;
    UserControl userControl;
    String successMessage="Thank You! Enjoy the Book.";
    String failureMessage="Sorry we don't have that books yet.";
    String talkToLibrarianMessage="Please talk to Librarian. Thank you.";
    private MovieControl movieControl;

    public MenuControl()
    {
        setBookControl(new BookControl());
        setMovieControl(new MovieControl());
        setUserControl(new UserControl());
        bookControl.createBooks();
    }
    public void setMovieControl(MovieControl movieControl)
    {
        this.movieControl=movieControl;
    }
    public void setUserControl(UserControl userControl)
    {
        this.userControl=userControl;
    }
    public void setBookControl(BookControl bookControl)
    {
        this.bookControl=bookControl;
    }

    public void loadScreen()
    {
        while (true)
        {
        System.out.println(welcomeMessage());
        int choice=readChoice();
        choice= validateMenuOption(choice);
        performActionBasedOnChoice(choice);
        }

    }

    void performActionBasedOnChoice(int choice) {
        switch (choice)
        {
            case 1:
                displayAllBooksNames();
                break;
            case 2:
                reserveBook();
                break;
            case 3:
                System.out.println(checkLibraryNumber());
                break;
            case 4:
                displayAllMovieNames();
                break;
            case 5:
                login();
                break;
        }
    }

    void login() {
        if(userControl.authenticate(readUser()))
            System.out.println("Logged In Successfully!");
        else
            System.out.print("Log in failed. Incorrect Username or Password");
    }

    User readUser()
    {
        System.out.println("Enter your username:");
        String uname=readString();
        System.out.println("Enter your password:");
        String passwd=readString();
        return new User(uname,passwd);
    }

    private String readString()
    {
        return new Scanner(System.in).next();
    }

    void displayAllMovieNames() {
        System.out.print(movieControl.listMovies());
    }

    void displayAllBooksNames() {
        System.out.println(bookControl.getBooksNames());
    }

    void reserveBook() {
        System.out.print("Enter the ISBN :");
        int choice= readChoice();
       System.out.println(bookControl.reserveBook(choice,successMessage,failureMessage));
    }


    public String checkLibraryNumber() {
        if(userControl.isLoggedIn())
            return userControl.getCurrentUserName();
        return talkToLibrarianMessage;
    }


    public int readChoice() {
        int choice=0;
        try
        {
        choice= new Scanner(System.in).nextInt();
        }
        catch (Exception e)
        {}
        return choice;
    }

    public String welcomeMessage()
    {
        return "\n-----------------------------\n\tWelcome to Biblioteca\n-----------------------------\n Menu:\n 1.View books\n 2.Reserve \n 3.Check Library number \n 4.View Movies \n 5.Login\n Enter your choice :";
    }

    public int validateMenuOption(int option) {
        int selected=option;
        if((selected>5)||(selected<1))
        {
            System.out.println(" Select a valid option!");
            selected=0;
        }
        return selected;
    }
}
