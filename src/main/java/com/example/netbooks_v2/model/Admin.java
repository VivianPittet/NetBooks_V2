package com.example.netbooks_v2.model;

import java.util.ArrayList;

public class Admin extends Person implements Tools{
    String UserAdmin;
    String passWorld;

    public Admin(String UserAdmin, String passWorld){

        super(UserAdmin,passWorld);
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
    public String SearchName() {
        return null;
    }

    @Override
    public ArrayList SearchWriter() {
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

    @Override
    public void SortBook() {

    }

    public void AddBook(){}

    public void RemoveBook(){}



    public void ModifyBook(){}
}
