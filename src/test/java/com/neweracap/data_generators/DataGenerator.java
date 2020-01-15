package com.neweracap.data_generators;

import java.util.*;

public class DataGenerator {
   private String unique () {
       Random r = new Random();
       return Integer.toString (r.nextInt());
   }

    public String getUserFirstName () {
        String userFName= "FirstValikTest";
        return userFName+unique();
    }
    public String getUserLastName () {
        String userLName= "LastValikTest";
        return userLName+unique();
    }

    public String getUserEmail () {
        String userMail= "FirstValikTest";
        return userMail+unique()+"@yopmail.com";
    }

    public String getPassword () {
        return "*Password12345#";
    }

    public HashMap<String, String> getUserData() {
        HashMap <String, String> userData = new HashMap<String, String>();
        userData.put("First Name", getUserFirstName ());
        userData.put("Last Name", getUserLastName ());
        userData.put("Email", getUserEmail());
        userData.put("Password", getPassword());
        return userData;
    }
}
