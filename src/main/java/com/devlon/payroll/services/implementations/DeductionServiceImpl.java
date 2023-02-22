package com.devlon.payroll.services.implementations;
import com.devlon.payroll.dto.DeductionDTO;
import com.devlon.payroll.entity.Deduction;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.DeductionRepo;
import com.devlon.payroll.services.DeductionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DeductionServiceImpl implements DeductionService {
    private final DeductionRepo deductionRepo;
    private final EmployeeServiceImpl employeeService;

    public DeductionServiceImpl(DeductionRepo deductionRepo, EmployeeServiceImpl employeeService) {
        this.deductionRepo = deductionRepo;
        this.employeeService = employeeService;
    }

    @Override
    public DeductionDTO saveDeduction(DeductionDTO deductionDTO, Long empId) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(empId);
        Deduction deduction = new Deduction();
        BeanUtils.copyProperties(deductionDTO, deduction);
        deduction.setEmployee(employee);

        return mapToDeduction(deductionRepo.save(deduction));
    }

    public DeductionDTO mapToDeduction(Deduction deduction) {
        return DeductionDTO.builder()
                .amount(deduction.getAmount())
                .type(deduction.getType())
                .build();
    }
}
