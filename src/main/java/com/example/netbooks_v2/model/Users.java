package com.example.netbooks_v2.model;

import java.util.ArrayList;
import java.util.Collections;

public class Users extends Person implements Tools {
    public Users (String Username ,String PassWord){

        super(Username, PassWord);
    }
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();
    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }

    public Book SearchName(String  BookName,ArrayList<Book> booklib) {
        Book SearchedBook=null;
        for(Book b: booklib){
            if (b.getName().equals(BookName)){
                SearchedBook = b;
            }
        }
        System.out.println("SearchName succes");
        return SearchedBook;
    }


    public ArrayList<Book>SearchWriter(String NameWriter,ArrayList<Book> booklib) {
        ArrayList<Book> searchedWriter = new ArrayList<Book>();
        for(Book b : booklib){
            if (b.getWriter().equals(NameWriter)){
                searchedWriter.add(b);
            }
        }
        System.out.println("succes writer");
        return searchedWriter;
    }

   // @Override
    public ArrayList SearchType(String type, ArrayList<Book> booklib) {
        ArrayList<Book> searchedType = new ArrayList();
        for(Book b : booklib){
            if (b.getType().equals(type)){
                searchedType.add(b);
            }
        }
        System.out.println("Succes type");
        return searchedType;

    }

   // @Override
    public ArrayList<String> sortByWriter(ArrayList<Book> booklib) {
        ArrayList<String> WriterLibrary = new ArrayList<String>();
        for(Book b: booklib) {
            if (!WriterLibrary.contains(b.getWriter())) {
                WriterLibrary.add(b.getWriter());
            }
        }
        Collections.sort(WriterLibrary);
        return WriterLibrary;
    }
    //@Override
    public ArrayList<String> sortByType(ArrayList<Book> booklib) {
        ArrayList<String> TypeLibrary = new ArrayList<>();
        for (Book b : booklib) {
            if (!TypeLibrary.contains(b.getType())) {
                TypeLibrary.add(b.getType());
            }
        }
        Collections.sort(TypeLibrary);
        return TypeLibrary;
    }
    public ArrayList sortByName(ArrayList<Book>booklib) {
        ArrayList<String> NameLibrary = new ArrayList<String>();
        for(Book b: booklib){
            NameLibrary.add(b.getName());
        }
        Collections.sort(NameLibrary);
        return NameLibrary;
    }

    //public void SortBook(){}

   /* public String  BuyBook(Book WishBook){
        ArrayList<String> SelectBook = new ArrayList<>();
        for (Book b: WishBook){
            SelectBook.add(b.getPrice());
        }


    }*/
    public String BuyBook(Book BookName,ArrayList<Book> booklib) {
        String WishBook = "Not the book";
        for(Book b: booklib){
            if (b.getName().equals(BookName)){
                WishBook = b.getName();
            }
        }
        System.out.println("get book");
        return WishBook;
    }


}
