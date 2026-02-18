package com.capgemini.cardPaymentAuthentication.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")
public class CardOpUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String created_at;

}
