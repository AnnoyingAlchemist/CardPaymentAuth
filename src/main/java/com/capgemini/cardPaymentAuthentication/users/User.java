package com.capgemini.cardPaymentAuthentication.users;

public record User(
        int user_id,
        String username,
        String password_hash,
        String role,
        Boolean active,
        String created_at
) {
}
