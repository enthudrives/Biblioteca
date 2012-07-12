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
    static BookControl b;
    public static void loadScreen()
    {
        b=new BookControl();
        while (true)
        {
        System.out.println(welcomeMessage());
        int choice=readChoice();
        choice=selectMenuOption(choice); //validate choice
        switch (choice)
        {
            case 1:
                System.out.println(b.getBooks());
                break;
            case 2:
                System.out.print("Enter the ISDN :");
                choice= readChoice();
                System.out.println(b.reserveBook(choice));
                break;
            case 3:
                System.out.println(Biblioteca.checkLibraryNumber());
                break;
            case 4:
                System.exit(1);
                break;
        }
        }

    }

    private static int readChoice() {
        int choice=0;
        try
        {
        choice= new Scanner(System.in).nextInt();
        }
        catch (Exception e)
        {}
        return choice;
    }

    public static String welcomeMessage()
    {
        return "\n-----------------------------\n\tWelcome to Biblioteca\n-----------------------------\n Menu:\n 1. View books\n 2.Reserve \n 3.Check Library number \n 4.Exit\n Enter your choice :";
    }

    public static int selectMenuOption(int option) {
        int selected=option;
        if((selected>4)||(selected<1))
        {
            System.out.println(" Select a valid option!");
            selected=0; //Returns 0 if invalid option is chosen
        }
        return selected;  //To change body of created methods use File | Settings | File Templates.
    }
}
