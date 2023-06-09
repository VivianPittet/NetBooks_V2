package com.example.netbooks_v2.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class admin
 */
public class Admin extends Person implements Tools{
    private String UserAdmin;
    private String passWorld;

    /**
     * Constructor
     * @param UserAdmin Name of admin 
     * @param passWorld password of admin
     */
    public Admin(String UserAdmin, String passWorld){

        super(UserAdmin,passWorld);
    }

    /**
     * Used to search a book's name
     * @param BookName Name of book to search
     * @return the serached book
     */
    public Book SearchName (String BookName, ArrayList<Book> booklib) {
        Book SearchedBook=null;
        for(Book b: booklib){
            if (b.getName().equals(BookName)){
                SearchedBook = b;
            }
        }
        return SearchedBook;
    }

    /**
     * Used to search books of a writer
     * @param writer Writer to search
     * @return a list of book with the resquested writer
     */
    public ArrayList<Book> SearchWriter(String writer, ArrayList<Book> booklib) {
        ArrayList<Book> searchedWriter = new ArrayList<Book>();
        for(Book b : booklib){
            if (b.getWriter().equals(writer)){
                searchedWriter.add(b);
            }
        }
        return searchedWriter;
    }
    /**
     * Used to search book by type
     * @param type type to search
     * @return list of book coresponding to the requested type
     */
    public ArrayList SearchType(String type, ArrayList<Book> booklib) {
        ArrayList<Book> searchedType = new ArrayList();
        for(Book b : booklib){
            if (b.getType().equals(type)){
                searchedType.add(b);
            }
        }
        return searchedType;
    }
    /**
     * Method to sort the library by name in alphabetic order
     * @return a Arraylist(string) of names
     */
    public ArrayList sortByName(ArrayList<Book>booklib) {
        ArrayList<String> NameLibrary = new ArrayList<String>();
        for(Book b: booklib){
            NameLibrary.add(b.getName());
        }
        Collections.sort(NameLibrary);
        return NameLibrary;
    }
    /**
     * Method to sort the library by writer in alphabetic order
     * @return a Arraylist(string) of writer
     */
    public ArrayList<String> sortByWriter(ArrayList<Book> booklib) {
        ArrayList<String> WriterLibrary = new ArrayList<String>();
        for(Book b: booklib){
            WriterLibrary.add(b.getWriter());
        }
        Collections.sort(WriterLibrary);
        return WriterLibrary;
    }
    /**
     *Method to sort by type in alphabetic order
     * @return a list of type
     */
    public ArrayList<String> sortByType(ArrayList<Book> booklib) {
        ArrayList<String> TypeLibrary = new ArrayList<>();
        for (Book b : booklib) {
            TypeLibrary.add(b.getType());
        }
        Collections.sort(TypeLibrary);
        return TypeLibrary;
    }


}
