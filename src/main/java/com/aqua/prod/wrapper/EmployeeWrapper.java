package com.aqua.prod.wrapper;

import com.aqua.prod.dto.EmployeeDto;
import com.aqua.prod.dto.RegisterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeWrapper {
    private RegisterDto user;
    private EmployeeDto employee;
}
