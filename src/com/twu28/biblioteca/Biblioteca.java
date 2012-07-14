package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/12/12
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */

public class Biblioteca
{
    private static MenuControl menu=new MenuControl();

    public static String checkLibraryNumber() {
        return "Please talk to Librarian. Thank you.";
    }

    public static void main(String[] args)
    {
            menu.loadScreen();
    }
}
