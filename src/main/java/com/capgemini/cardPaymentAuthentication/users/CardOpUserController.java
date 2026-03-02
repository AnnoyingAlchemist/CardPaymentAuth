package com.capgemini.cardPaymentAuthentication.users;


import com.capgemini.cardPaymentAuthentication.AuthRequest;
import com.capgemini.cardPaymentAuthentication.service.JwtService;
import com.capgemini.cardPaymentAuthentication.service.myUserDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class CardOpUserController {
    private final CardOpUserRepository cardOpUserRepository;
    private final myUserDetailsService myUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CardOpUserController(CardOpUserRepository cardOpUserRepository, myUserDetailsService myUserDetailsService, PasswordEncoder passwordEncoder) {
        this.cardOpUserRepository = cardOpUserRepository;
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping(path = "/users")
    @Operation(summary = "Returns a list of all users in the database.")
    public List<CardOpUser> getUsers(){
        return cardOpUserRepository.findAll();
    }


    @GetMapping(path =  "/users/{id}")
    @Operation(summary = "Finds a user by their id.")
    public CardOpUser getUserById(@PathVariable String id){
        return cardOpUserRepository.findByUserId(id);
    }

    //Should only be accessible by admin roles
    @PostMapping("/create")
    @Operation(summary = "Creates a user in the database. Username must be unique.")
    public void createCardOpUser(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam Role role,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String fullName){
        CardOpUser user = new CardOpUser();
        user.setUsername(username);
        user.setPassword_hash(passwordEncoder.encode(password));
        user.setRoles(role.name());
        //user.setRoles(Objects.requireNonNullElse(role.name(), "none"));
        user.setCreated_at(LocalDateTime.now());
        user.setActive(true);
        user.setEmail(email);
        user.setFull_name(fullName);
        cardOpUserRepository.save(user);
    }

    @PostMapping(path = "/login")
    @Operation(summary = "Generates JWT token when given correct username / password.")
    public String authenticate(@RequestBody AuthRequest authRequest){
        try{

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()));

        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        } catch (AuthenticationException e) {
            return "Incorrect credentials";
        }
        return null;

    }
/*
    @PostMapping(path = "/token/system")
    public boolean SystemLogin(){
        return true;
    }

 */
    //TODO: add better exception handling
}
