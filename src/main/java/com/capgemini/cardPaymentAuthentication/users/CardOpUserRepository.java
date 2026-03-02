package com.capgemini.cardPaymentAuthentication.users;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@NullMarked
public interface CardOpUserRepository extends JpaRepository<CardOpUser, String> {
    CardOpUser findByUserId(String id);
    CardOpUser findByUsername(String userName);
}
