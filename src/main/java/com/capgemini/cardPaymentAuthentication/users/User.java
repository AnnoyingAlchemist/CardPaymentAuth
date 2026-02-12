package com.capgemini.cardPaymentAuthentication.users;

import lombok.Builder;

@Builder
public record User(
        int user_id,
        String username,
        String password_hash,
        String role,
        Boolean active,
        String created_at
) {
}
