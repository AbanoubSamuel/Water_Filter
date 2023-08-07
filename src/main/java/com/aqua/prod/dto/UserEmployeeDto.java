package com.aqua.prod.dto;

import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.dto.RegisterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEmployeeDto {
    private RegisterDto user;
    private EmployeeDto employee;
}
