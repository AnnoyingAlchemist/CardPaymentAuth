package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    //TODO: Change out later, keep for now as test data
    private final List<User> userList = List.of(
            new User(1,"Brandon","???",
                    "ROLE_FRAUD_ANALYST",true,"2/12/26"),
            new User(2,"Bill","unknown",
                             "ROLE_GUEST",false,"3/02/25")
    );

    public Optional<User> findById(int id){
        //User user = new User(1,"Brandon","???","ROLE_FRAUD_ANALYST",true,"2/12/26");
        return userList.stream()
            .filter(user -> user.user_id() == id)
            .findAny();
    }

    public List<User> findAll(){
        return userList;
    }
}
