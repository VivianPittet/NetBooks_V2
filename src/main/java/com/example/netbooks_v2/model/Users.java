package com.example.netbooks_v2.model;

import java.util.ArrayList;

public class Users extends Person implements Tools {
    public Users (String Username ,String PassWord){

        super(Username, PassWord);
    }
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();
    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }
    @Override
    public String SearchName(Book BookName) {

      return null;
    }

    @Override
    public ArrayList SearchWriter() {
        return null;
    }

    @Override
    public ArrayList<String> sortByWriter() {
        return null;
    }

    @Override
    public ArrayList<String> sortByType() {
        return null;
    }

    @Override
    public ArrayList SearchType() {
        return null;
    }

    @Override
    public ArrayList sortByName() {
        return null;
    }

    public void SortBook(){}

    public void BuyBook(){}

}
