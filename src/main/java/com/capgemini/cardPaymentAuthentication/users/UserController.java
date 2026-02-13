package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")
    public List<User> getUsers(){
        System.out.println("HI");
        return userRepository.findAll();
    }

    @GetMapping(path =  "/users/{id}")
    public List<User> getUserById(@PathVariable int id){
        return userRepository.findByUser_id(id);
    }

    @PostMapping(path = "/login")
    public boolean Login(){
        return true;
    }

    @PostMapping(path = "/token/system")
    public boolean SystemLogin(){
        return true;
    }
    //TODO: add exception handling
}
