package com.devlon.payroll.services.implementations;

import com.devlon.payroll.dto.EmployeeDTO;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.EmployeeRepository;
import com.devlon.payroll.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) throws AlreadyExistException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Employee existingEmployee = employeeRepository.findByName(employeeDTO.getName());
        if(existingEmployee != null) {
            throw new AlreadyExistException("Employee already exist");
        }
        employeeRepository.save(employee);
        return mapToEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long empId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employee.get();
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployee).collect(Collectors.toList());
    }

    public EmployeeDTO mapToEmployee(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .netPay(employee.getNetPay())
                .grossPay(employee.getGrossPay())
                .build();
    }
}
