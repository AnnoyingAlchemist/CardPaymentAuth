package com.capgemini.cardPaymentAuthentication.users;


import jakarta.persistence.*;
import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")
public class CardOpUser {
    //GenerationType AUTO used since other strategies do not seem to work with the db
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private String userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    //BCrypt hashed
    private String password_hash;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    private String full_name;

    @Column
    private String email;

    @Column
    private Boolean active;
    @Column
    private LocalDateTime created_at;

}
