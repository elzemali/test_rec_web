package com.example.david_test.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * WebSecurityConfig is autoconfiguation class to config project security by defining some beans
 * @author El amine
 * @version 0.1
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


    /**
     * Returns  DefaultSecurityFilterChain of application after request check with filter
     * filter here authorize users with role user to access to any url
     * @param http
     * @return instance of SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/**").hasRole("USER").and().httpBasic();
        return http.build();
    }

    /**
     * Create a default user with role user
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("ostendi")
                .password("recr")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
