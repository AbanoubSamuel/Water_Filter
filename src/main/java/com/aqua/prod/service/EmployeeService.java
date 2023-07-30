package com.aqua.prod.service;

import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.entity.Employee;
import com.aqua.prod.exception.UserExistsException;

public interface EmployeeService {
    Employee createUserAndEmployee(RegisterDto registerDto, EmployeeDto employeeDto) throws UserExistsException;
}
