package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.UserRepo;
import com.aqua.prod.dto.LoginDto;
import com.aqua.prod.dto.RegistrationDto;
import com.aqua.prod.dto.UserDto;
import com.aqua.prod.entity.User;
import com.aqua.prod.exception.UserExistsException;
import com.aqua.prod.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private EncryptionServiceImpl encryptionService;
    private JWTServiceImpl jwtService;

    public UserServiceImpl(UserRepo userRepo, EncryptionServiceImpl encryptionService, JWTServiceImpl jwtService)
    {
        this.userRepo = userRepo;
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

    public User register(RegistrationDto registrationDto) throws UserExistsException
    {
        if (userRepo.findByUserNameIgnoreCase(registrationDto.getUserName()).isPresent()
                || userRepo.findByEmailIgnoreCase(registrationDto.getEmail()).isPresent()) {
            throw new UserExistsException();
        }

        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setPassword(encryptionService.encryptPassword(registrationDto.getPassword()));
        return userRepo.save(user);
    }

    public UserDto updateUserProfile(User user, UserDto userDto) throws Exception
    {
        userDto.setPassword(encryptionService.encryptPassword(userDto.getPassword()));
        userRepo.save(UserDto.convertDtoToUser(user,userDto));
        return userDto;

    }
}
