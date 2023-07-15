package com.aqua.prod.model;

import com.aqua.prod.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.User}
 */

@Data
public class UserDto implements Serializable {
    @NotNull
    @Size(max = 100)
    private String userName;
    @NotNull
    @Size(max = 100)
    private String firstName;
    @NotNull
    @Size(max = 100)
    private String lastName;
    @NotNull
    @Size(max = 100)
    private String email;
    @NotNull
    @Size(max = 100)
    private String password;
    @NotNull
    @Size(max = 100)
    private String phoneNumber;
    String fcm;
    private byte[] image;
    @Size(max = 500)
    private String description;

    public static User convertDtoToUser(User user,UserDto userDto)
    {
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setImage(userDto.getImage());
        user.setDescription(userDto.getDescription());

        return user;
    }
}