package com.capgemini.cardPaymentAuthentication.users;


import com.capgemini.cardPaymentAuthentication.AuthRequest;
import com.capgemini.cardPaymentAuthentication.service.JwtService;
import com.capgemini.cardPaymentAuthentication.service.myUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<CardOpUser> getUsers(){
        return cardOpUserRepository.findAll();
    }


    @GetMapping(path =  "/users/{id}")
    public CardOpUser getUserById(@PathVariable String id){
        return cardOpUserRepository.findByUserId(id);
    }

    //Endpoint for testing ONLY
    @PostMapping("/create")
    public void createCardOpUser(@RequestParam String username,
                                   @RequestParam String password){
        CardOpUser user = new CardOpUser();
        user.setUsername(username);
        user.setPassword_hash(passwordEncoder.encode(password));
        user.setRoles("test");

        cardOpUserRepository.save(user);
    }

    @PostMapping(path = "/login")
    public String authenticate(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()));

        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        return null;

    }

    @PostMapping(path = "/token/system")
    public boolean SystemLogin(){
        return true;
    }
    //TODO: add exception handling
}
