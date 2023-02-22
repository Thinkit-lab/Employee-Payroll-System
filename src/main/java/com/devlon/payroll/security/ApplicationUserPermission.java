package com.devlon.payroll.security;

public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    DEDUCTION_READ("deduction:read"),
    DEDUCTION_WRITE("deduction:write"),
    APPROVAL_READ("approval:read"),
    APPROVAL_WRITE("approval:write"),
    PAYROLL_READ("payroll:read"),
    PAYROLL_WRITE("payroll:write");
    private final String permission;
    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
