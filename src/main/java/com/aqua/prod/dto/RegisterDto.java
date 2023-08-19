package com.aqua.prod.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterDto {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
