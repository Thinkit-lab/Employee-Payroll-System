package com.devlon.payroll.services.implementations;

import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.EmployeeRepository;
import com.devlon.payroll.security.ApplicationUserRole;
import com.devlon.payroll.services.CustomUserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Employee user = employeeRepository.findByEmail(email);
//        user.setEnabled(true);
        if(user == null) {
            try {
                throw new EmployeeNotFoundException("No user found");
            } catch (EmployeeNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        user.setEnabled(true);
        return new org.springframework.security.core.userdetails.User (
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                user.isEnabled(),
                true,
                true,
                true,
                (user.getRole()).getGrantedAuthorities()
        );
    }
}
