package com.capgemini.cardPaymentAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
//TODO: REMOVE THE (exclude = {DataSourceAutoConfiguration.class}) when adding a database
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CardPaymentAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardPaymentAuthenticationApplication.class, args);
	}

}
