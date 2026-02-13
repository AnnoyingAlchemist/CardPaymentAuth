package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public List<User> findByUserId(int id);

}
