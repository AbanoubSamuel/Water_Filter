package com.aqua.prod.dto;

import com.aqua.prod.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.User}
 */

@Data
public class UserUpdateDto implements Serializable {
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

    public static User convertDtoToUser(User user, UserUpdateDto userUpdateDto)
    {
        user.setUserName(userUpdateDto.getUserName());
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(userUpdateDto.getPassword());
        user.setPhoneNumber(userUpdateDto.getPhoneNumber());
        user.setImage(userUpdateDto.getImage());
        user.setDescription(userUpdateDto.getDescription());

        return user;
    }
}