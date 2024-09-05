package com.javaproject.ems_backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaproject.ems_backend.dto.EmployeeDto;
import com.javaproject.ems_backend.entity.Employee;
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

}
