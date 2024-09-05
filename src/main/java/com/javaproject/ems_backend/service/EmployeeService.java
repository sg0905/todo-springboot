package com.javaproject.ems_backend.service;

import java.util.List;

import com.javaproject.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updaEmployeeDto);

    void deleteEmployee(Long employeeId);
    
}
