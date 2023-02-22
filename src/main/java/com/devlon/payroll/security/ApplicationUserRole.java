package com.devlon.payroll.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.devlon.payroll.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    EMPLOYEE(new HashSet<>()),
    ADMIN(new HashSet<>(Set.of(EMPLOYEE_WRITE, EMPLOYEE_READ, DEDUCTION_WRITE, DEDUCTION_READ))),
    COMPENSATION_ADMIN(new HashSet<>(Set.of(EMPLOYEE_WRITE, EMPLOYEE_READ, DEDUCTION_WRITE, DEDUCTION_READ,
            APPROVAL_WRITE, APPROVAL_READ, PAYROLL_WRITE, PAYROLL_READ)));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority>  getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
