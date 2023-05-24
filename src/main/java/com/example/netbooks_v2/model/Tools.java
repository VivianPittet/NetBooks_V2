package com.example.netbooks_v2.model;

import java.util.ArrayList;

public interface Tools
{
    public String SearchName();
    public ArrayList<String> SearchWriter();
    public ArrayList<String> SearchType();
    public ArrayList<String> sortByName();
    public ArrayList<String> sortByWriter();
    public ArrayList<String> sortByType();

    public void SortBook();
}
