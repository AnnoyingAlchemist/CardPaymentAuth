package com.capgemini.cardPaymentAuthentication.users;


import com.capgemini.cardPaymentAuthentication.service.myUserDetailsService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class CardOpUserController {
    private final CardOpUserRepository cardOpUserRepository;
    private final myUserDetailsService myUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CardOpUserController(CardOpUserRepository cardOpUserRepository, myUserDetailsService myUserDetailsService, PasswordEncoder passwordEncoder) {
        this.cardOpUserRepository = cardOpUserRepository;
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping(path = "/users")
    public List<CardOpUser> getUsers(){
        return cardOpUserRepository.findAll();
    }


    @GetMapping(path =  "/users/{id}")
    public CardOpUser getUserById(@PathVariable String id){
        return cardOpUserRepository.findByUserId(id);
    }

    @PostMapping(path="/users/create")
    public void saveCardOpUser(@RequestBody String username,
                                     @RequestBody String password) throws BadRequestException {
        CardOpUser user = new CardOpUser();
        user.setUsername(username);
        user.setPassword_hash(passwordEncoder.encode(password));

        cardOpUserRepository.save(user);
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
