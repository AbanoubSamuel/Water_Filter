package com.aqua.prod.api.controller;


import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.respons.BaseResponse;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.entity.Employee;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.serviceImpl.EmployeeServiceImpl;
import com.aqua.prod.dto.UserEmployeeDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService)
    {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Employee>> createEmployee(@AuthenticationPrincipal  @Validated @RequestBody UserEmployeeDto userEmployeeDto) throws UserExistsException
    {
        RegisterDto registerDto = userEmployeeDto.getUser();
        EmployeeDto employeeDto = userEmployeeDto.getEmployee();
        Employee employee = employeeService.createUserAndEmployee(registerDto, employeeDto);
        BaseResponse<Employee> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(true);
        baseResponse.setMessage("Successfully created employee");
        baseResponse.setData(employee);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(201));
    }
}
