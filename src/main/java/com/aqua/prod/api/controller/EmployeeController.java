package com.aqua.prod.api.controller;


import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.entity.Employee;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.serviceImpl.EmployeeServiceImpl;
import com.aqua.prod.wrapper.EmployeeWrapper;
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
    public ResponseEntity<JsonResponse<Employee>> createEmployee(@AuthenticationPrincipal  @Validated @RequestBody EmployeeWrapper employeeWrapper) throws UserExistsException
    {
        RegisterDto registerDto = employeeWrapper.getUser();
        EmployeeDto employeeDto = employeeWrapper.getEmployee();
        Employee employee = employeeService.createUserAndEmployee(registerDto, employeeDto);
        JsonResponse<Employee> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Successfully created employee");
        jsonResponse.setData(employee);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }
}
