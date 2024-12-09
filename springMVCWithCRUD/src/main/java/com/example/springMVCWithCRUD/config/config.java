package com.example.springMVCWithCRUD.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class config {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http , CustomAuthenticationSuccessHandler successHandler) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET,"/employees").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.GET,"/employees/**").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.POST,"/employees").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.PUT,"/employees").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.DELETE,"/employees").hasRole("ADMIN")
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .successHandler(successHandler)
                                .permitAll()
                ).logout(logout->logout.permitAll()).exceptionHandling(exceptionhandling->exceptionhandling.accessDeniedHandler(accessDeniedHandler()))
;
        return http.build();
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("<html><body><h1>Access Denied</h1><p>You do not have permission to access this page.</p><a href='/showMyLoginPage'>Go to Home</a></body></html>");
        };
    }
}











