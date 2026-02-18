package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.cardPaymentAuthentication.users.*;
import java.util.List;


@Repository
public interface CardOpUserRepository extends JpaRepository<CardOpUser, String> {
    public CardOpUser findByUserId(String id);
}
