package com.aqua.prod.serviceImpl;

import com.aqua.prod.common.exception.UserExistsException;
import com.aqua.prod.datarest.EmployeeRepo;
import com.aqua.prod.datarest.UserRepo;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegisterDto;
import com.aqua.prod.dto.UserDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private EmployeeRepo employeeRepo;
    private EncryptionServiceImpl encryptionService;
    private JWTServiceImpl jwtService;

    public UserServiceImpl(UserRepo userRepo, EmployeeRepo employeeRepo, EncryptionServiceImpl encryptionService, JWTServiceImpl jwtService)
    {
        this.userRepo = userRepo;
        this.employeeRepo = employeeRepo;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }


    @Override
    public String login(LoginDto loginDto)
    {
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
    public User register(RegisterDto registerDto) throws UserExistsException
    {
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
    public UserDto updateUserProfile(User user, UserDto userDto) throws Exception
    {
        userDto.setPassword(encryptionService.encryptPassword(userDto.getPassword()));
        userRepo.save(UserDto.convertDtoToUser(user, userDto));
        return userDto;

    }
}
