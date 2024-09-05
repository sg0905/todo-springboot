package com.javaproject.ems_backend.mapper;

import com.javaproject.ems_backend.dto.EmployeeDto;
import com.javaproject.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maEmployeeDto(Employee employee){
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }
    public static Employee mapTEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        ); 
    }

}
