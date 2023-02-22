package com.devlon.payroll.services;

import com.devlon.payroll.dto.EmployeeDTO;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException, AlreadyExistException;

    Employee getEmployeeById(Long empId) throws EmployeeNotFoundException;

    List<EmployeeDTO> getAllEmployee();

}
