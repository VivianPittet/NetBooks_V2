package com.example.netbooks_v2.model;

public class Admin extends Person implements Tools{
    String UserAdmin;
    String passWorld;

    public Admin(String UserAdmin, String passWorld){

        super(UserAdmin,passWorld);
    }

    public void SearchBook(){}

    public void SortBook(){}

    public void AddBook(){}

    public void RemoveBook(){}



    public void ModifyBook(){}
}
