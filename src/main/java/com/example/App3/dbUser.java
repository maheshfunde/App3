package com.example.App3;

import java.util.ArrayList;
import java.util.List;

public class dbUser {
    private List<user> userTable=new ArrayList<user>();

    public dbUser() {
        userTable.add(new user(1,"Mahesh",30));
        userTable.add(new user(2,"Arjun",50));
        userTable.add(new user(3,"Funde",60));
    }

    public List<user> getAllUsers(){ //for getting list of all users in database
        return userTable;
    }

    public user getAUser(int id){  //for getting a single user of specific id from database
        for (user user:userTable){
            if (user.getId()==id) return user;
        }
        return null;
    }
    public user getAUserByName(String name){

        for (user user:userTable){
            if (user.getName().equals(name)) return user;
        }
        return null;

    }

    //methods for POST call

    public user createUser(user user){
        userTable.add(user);
        return user;
    }

    public boolean deleteUser(int id){
        for (user user:userTable){
            if (user.getId()==id){
                userTable.remove(user);
                return true;
            }
        }
        return false;

    }
}
