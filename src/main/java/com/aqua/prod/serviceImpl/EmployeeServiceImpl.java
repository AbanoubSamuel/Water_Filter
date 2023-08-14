package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.EmployeeRepo;
import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.entity.Employee;
import com.aqua.prod.entity.User;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.service.EmployeeService;
import com.aqua.prod.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private UserService userService;
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(UserService userService, EmployeeRepo employeeRepo)
    {
        this.userService = userService;
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Transactional
    public Employee createUserAndEmployee(RegisterDto registerDto, EmployeeDto employeeDto) throws UserExistsException
    {
        User user = userService.register(registerDto);
        Employee employee = new Employee();
        employee.setUser(user);
        employeeRepo.save(EmployeeDto.convertDtoToEmployee(employeeDto, employee));
        return employee;
    }
}
