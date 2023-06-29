package com.aqua.prod.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
