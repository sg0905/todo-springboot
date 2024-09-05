package com.javaproject.ems_backend.service.impl;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaproject.ems_backend.dto.EmployeeDto;
import com.javaproject.ems_backend.entity.Employee;
import com.javaproject.ems_backend.exception.ResourceNotFoundException;
import com.javaproject.ems_backend.mapper.EmployeeMapper;
import com.javaproject.ems_backend.repository.EmployeeRepository;
import com.javaproject.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor


public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub

        Employee employee = EmployeeMapper.mapTEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                     new ResourceNotFoundException("Employee is not exists with given id :" + employeeId));    
        return EmployeeMapper.maEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        // TODO Auto-generated method stub
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.maEmployeeDto(employee))
            .collect(Collectors.toList());
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException(("Employee is not exists with given Id: " + employeeId))
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.maEmployeeDto(updatedEmployeeObj);
        
    }
    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException(("Employee is not exists with given Id: " + employeeId))
        );

        employeeRepository.deleteById(employeeId);
        //throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
}
