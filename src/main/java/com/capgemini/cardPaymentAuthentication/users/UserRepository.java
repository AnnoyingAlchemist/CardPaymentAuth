package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepository {
    private ArrayList<User> userList = new ArrayList<>();
    //private User customer = new User();

    public User findById(){
        return new User(1,"","","",true,"");
    }
}
