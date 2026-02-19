package com.capgemini.cardPaymentAuthentication.service;

import com.capgemini.cardPaymentAuthentication.users.CardOpUser;
import com.capgemini.cardPaymentAuthentication.users.CardOpUserRepository;
import org.apache.coyote.BadRequestException;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    private CardOpUserRepository userRepo;

/*

    public CardOpUser createCardOpUser(CardOpUser user) throws BadRequestException {
        if (user.getUsername() == null ||
                user.getPassword_hash() == null || user.getRoles() == null) {
            throw new BadRequestException("User ID, Password, and role is required");
        }
        return userRepo.save(user);
    }
 */

    public CardOpUser getUserFromUsername(String username){
        return userRepo.findByUserId(username);

    }

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CardOpUser user = getUserFromUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        return User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword_hash())
                .authorities(Collections.emptyList())
                .build();
    }


    public UserDetailsService userDetailsService(){
        return new myUserDetailsService();
    }

}
