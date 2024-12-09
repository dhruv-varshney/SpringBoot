package com.example.springMVCWithCRUD.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class CustomUserDetailsService implements UserDetailsService {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    public CustomUserDetailsService(JdbcUserDetailsManager jdbcUserDetailsManager) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(username);
        System.out.println("User Details: " + userDetails);
        return userDetails;
    }
}
