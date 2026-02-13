package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /*
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
*/
    public List<User> findByUser_id(int id);

}
