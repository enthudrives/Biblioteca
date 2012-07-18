package com.twu28.biblioteca;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */

public class MenuControl {
    BookControl bookControl =new BookControl();
    String successMessage="Thank You! Enjoy the Book.";
    String failureMessage="Sorry we don't have that books yet.";
    String talkToLibrarianMessage="Please talk to Librarian. Thank you.";

    public MenuControl()
    {
        bookControl.createBooks();
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
                System.exit(1);
                break;
        }
    }

    void displayAllBooksNames() {
        System.out.println(bookControl.getBooksNames());
    }

    void reserveBook() {
        System.out.print("Enter the ISBN :");
        int choice= readISBN();
       System.out.println(bookControl.reserveBook(choice,successMessage,failureMessage));
    }

    int readISBN() {
        return readChoice();
    }

    public String checkLibraryNumber() {
        return talkToLibrarianMessage;
    }


    int readChoice() {
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
        return "\n-----------------------------\n\tWelcome to Biblioteca\n-----------------------------\n Menu:\n 1. View books\n 2.Reserve \n 3.Check Library number \n 4.Exit\n Enter your choice :";
    }

    public int validateMenuOption(int option) {
        int selected=option;
        if((selected>4)||(selected<1))
        {
            System.out.println(" Select a valid option!");
            selected=0;
        }
        return selected;
    }
}
