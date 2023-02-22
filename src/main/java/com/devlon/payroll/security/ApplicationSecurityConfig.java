package com.devlon.payroll.security;

import com.devlon.payroll.jwt.JwtTokenVerfier;
import com.devlon.payroll.jwt.JwtUserNameAndPasswordAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ApplicationSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(11);
    }

//    @Bean
//    AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .cors()
//                .and()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUserNameAndPasswordAuthFilter(authentication -> authentication))
                .addFilterAfter(new JwtTokenVerfier(), JwtUserNameAndPasswordAuthFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/", "/index.html").permitAll()
//                .requestMatchers("/api/v1/employee/**").permitAll()
                .requestMatchers("/api/**").hasRole(ApplicationUserRole.EMPLOYEE.name())
//                .requestMatchers(HttpMethod.POST, "/api/v1/employee/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
                .requestMatchers("/api/v1/admin/**").hasRole(ApplicationUserRole.COMPENSATION_ADMIN.name())
                .anyRequest()
                .authenticated();
//                .and()
//                .formLogin();


        return httpSecurity.build();
    }
}
