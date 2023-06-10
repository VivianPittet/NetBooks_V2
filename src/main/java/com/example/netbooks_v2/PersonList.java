package com.example.netbooks_v2;

import com.example.netbooks_v2.model.Admin;
import com.example.netbooks_v2.model.Person;

import java.util.ArrayList;

/**
 * Class with all people who have a account
 */

public class PersonList {
    private ArrayList<Person> allPerson = new ArrayList<Person>();

   public PersonList (Person p){
       allPerson.add(p);}

        public PersonList (){
   }
   public void addPerson(Person per){
       allPerson.add(per);
   }
   public ArrayList<Person> getList(){
       return allPerson;
   }
}
