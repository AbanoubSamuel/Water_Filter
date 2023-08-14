package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.EmployeeRepo;
import com.aqua.prod.datarest.UserRepo;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.dto.UserUpdateDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.service.EncryptionService;
import com.aqua.prod.service.JWTService;
import com.aqua.prod.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private EmployeeRepo employeeRepo;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserServiceImpl(UserRepo userRepo, EmployeeRepo employeeRepo, EncryptionService encryptionService, JWTService jwtService) {
        this.userRepo = userRepo;
        this.employeeRepo = employeeRepo;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }


    @Override
    public String login(LoginDto loginDto) {
        Optional<User> optUser = userRepo.findByUserNameIgnoreCase(loginDto.getUserName());
        if (optUser.isPresent()) {
            User user = optUser.get();
            if (encryptionService.verifyPassword(loginDto.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }

        return null;
    }

    @Override
    public User register(RegisterDto registerDto) throws UserExistsException {
        if (userRepo.findByUserNameIgnoreCase(registerDto.getUserName()).isPresent()
                || userRepo.findByEmailIgnoreCase(registerDto.getEmail()).isPresent()) {
            throw new UserExistsException();
        }

        User user = new User();
        user.setUserName(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setPassword(encryptionService.encryptPassword(registerDto.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserUpdateDto updateUserProfile(User user, UserUpdateDto userUpdateDto) throws Exception {
        userUpdateDto.setPassword(encryptionService.encryptPassword(userUpdateDto.getPassword()));
        userRepo.save(UserUpdateDto.convertDtoToUser(user, userUpdateDto));
        return userUpdateDto;

    }
}
