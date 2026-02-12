package com.capgemini.cardPaymentAuthentication.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("/login")
    public boolean Login(){
        return true;
    }

    @PostMapping("/token/system")
    public boolean SystemLogin(){
        return true;
    }
}
