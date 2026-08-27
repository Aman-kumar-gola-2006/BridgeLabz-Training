package com.fundoo.notes.config;

/*
 =========================================================================================
  PRACTICE & LEARNING NOTE FOR FRESHERS / BEGINNERS:
  -----------------------------------------------------------------------------------------
  IN-MEMORY AUTHENTICATION (COMMENTED OUT FOR PRACTICE)
  
  What is In-Memory Authentication?
  - In-memory authentication stores user credentials (username, password, roles) directly 
    in the application's RAM (memory) instead of fetching from a real database.
  - Useful for quick testing, prototypes, or learning Spring Security basics.
  
  Why is this commented out?
  - We have commented out this configuration because we are using DB-based authentication
    (UserDetailsService + JPA + UserRepository) along with JWT (JSON Web Token) authentication.
  
  If you want to practice in-memory auth:
  1. Uncomment the @Configuration and @Bean annotations below.
  2. Comment out the custom UserDetailsService / SecurityFilterChain in SecurityConfig.java.
 =========================================================================================
*/

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
public class InMemorySecurityConfig {

    //@Bean
    public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        // Creating hardcoded user 1
        UserDetails user1 = User.builder()
                .username("fresher@example.com")
                .password(passwordEncoder.encode("fresher123"))
                .roles("USER")
                .build();

        // Creating hardcoded user 2 (Admin)
        UserDetails admin1 = User.builder()
                .username("admin@example.com")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        // Storing users in memory
        return new InMemoryUserDetailsManager(user1, admin1);
    }
}
*/
public class InMemorySecurityConfig {
    // Left empty as reference documentation for Freshers
}
