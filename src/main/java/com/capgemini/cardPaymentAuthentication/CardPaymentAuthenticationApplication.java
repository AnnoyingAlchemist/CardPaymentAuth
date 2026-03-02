package com.capgemini.cardPaymentAuthentication;

import com.capgemini.cardPaymentAuthentication.users.CardOpUser;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class    CardPaymentAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardPaymentAuthenticationApplication.class, args);
	}

}
