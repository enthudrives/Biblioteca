package com.twu28.biblioteca.Controls;

import com.twu28.biblioteca.Components.User;

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
    MovieControl movieControl;
    User currentUser=null;
    public static final String SUCCESS_MESSAGE ="Thank You! Enjoy the Book.";
    public static final String FAILURE_MESSAGE ="Sorry we don't have that book yet.";
    public static final String TALK_TO_LIBRARIAN_MESSAGE ="Please talk to Librarian. Thank you.";

    public MenuControl()
    {
        bookControl=new BookControl();
        bookControl.createBooks();

        movieControl=new MovieControl();
        movieControl.createMovies();

        userControl=new UserControl();
        userControl.createUsers();
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

    public void performActionBasedOnChoice(int choice) {
        switch (choice)
        {
            case 1:
                displayAllBooksNames();
                break;
            case 2:
                if(currentUser!=null)
                    reserveBook();
                else
                    System.out.print("You should be logged in to do this!");
                break;
            case 3:
                System.out.println(checkLibraryNumber());
                break;
            case 4:
                displayAllMovieNames();
                break;
            case 5:
                if(currentUser!=null)
                    System.out.print("You are already logged in");
                else
                    login();
                break;
        }
    }

    void login() {
        User user=readUser();
        if(userControl.authenticate(user))
        {
            System.out.println("Logged In Successfully!");
            setCurrentUser(user);
        }
        else
            System.out.print("Log in failed. Incorrect Username or Password");
    }

    public User readUser()
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

    public void displayAllMovieNames() {
        System.out.print(movieControl.getList());
    }

    public void displayAllBooksNames() {
        System.out.println(bookControl.getList());
    }

    public void reserveBook() {
        System.out.print("Enter the ISBN :");
        int isbn= readChoice();
       System.out.println(bookControl.reserveBook(isbn));
    }


    public String checkLibraryNumber() {
        if(currentUser!=null)
            return currentUser.getUserName();
        return TALK_TO_LIBRARIAN_MESSAGE;
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
        return "\n-----------------------------\n\tWelcome to Biblioteca\n-----------------------------\n Menu:\n 1.View Books\n 2.Reserve Books \n 3.Check Library number \n 4.View Movies \n 5.Login\n Enter your choice :";
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

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
