package com.capgemini.cardPaymentAuthentication.users;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class CardOpUserController {
    private final CardOpUserRepository cardOpUserRepository;

    public CardOpUserController(CardOpUserRepository cardOpUserRepository) {
        this.cardOpUserRepository = cardOpUserRepository;
    }

    @GetMapping(path = "/users")
    public List<CardOpUser> getUsers(){
        return cardOpUserRepository.findAll();
    }

    @GetMapping(path =  "/users/{id}")
    public CardOpUser getUserById(@PathVariable String id){
        return cardOpUserRepository.findByUserId(id);
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
