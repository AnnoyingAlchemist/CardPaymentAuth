package com.capgemini.cardPaymentAuthentication.config;
import com.capgemini.cardPaymentAuthentication.service.myUserDetailsService;
import com.capgemini.cardPaymentAuthentication.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/auth/login","/swagger-ui/**","/v3/api-docs*/**")
                                .permitAll()

                                .requestMatchers(HttpMethod.POST, "/auth/create")
                                .hasRole(Role.SYSTEM.name())

                                .requestMatchers(HttpMethod.GET, "/auth/users/**")
                                .hasAnyRole(Role.SYSTEM.name())


                                .anyRequest()
                                .authenticated())
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                //.httpBasic(Customizer.withDefaults());
                //.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
        //http.formLogin(Customizer.withDefaults()); // Enables form

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new myUserDetailsService();
    }

   @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
       DaoAuthenticationProvider provider =
               new DaoAuthenticationProvider(userDetailsService);
       provider.setPasswordEncoder(passwordEncoder);
       //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
       return new ProviderManager(provider);
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
   }
}
