package com.capgemini.cardPaymentAuthentication.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String userId;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    //BCrypt hashed
    String password_hash;

    @Column(nullable = false)
    String roles;

    @Column(nullable = false)
    String full_name;

    @Column
    String email;

    @Column
    Boolean active;
    @Column
    String created_at;

}
