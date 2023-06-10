package com.example.netbooks_v2.model;

public class Person {
    private String UserName;
    private String PassWorld;
    private String[][] accounts = {{"anthony", "supernova"},{"steve", "java1"}};
    public Person(String UserName, String PassWorld){
        this.UserName=UserName;
        this.PassWorld=PassWorld;
    }
    public boolean checkPassword()
    {

        if((UserName.equals(accounts[0][0])) && (PassWorld.equals(accounts[0][1])))
            return true;
        else
            return false;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWorld() {
        return PassWorld;
    }

    public void setPassWorld(String passWorld) {
        PassWorld = passWorld;
    }
}
