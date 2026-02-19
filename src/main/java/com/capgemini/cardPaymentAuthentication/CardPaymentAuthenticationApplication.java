package com.capgemini.cardPaymentAuthentication;

import com.capgemini.cardPaymentAuthentication.users.CardOpUser;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
            title="User API",
            version="1.0",
            description = "API documentation for authenticating users"
    )
)


@SpringBootApplication
public class    CardPaymentAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardPaymentAuthenticationApplication.class, args);
	}

}
