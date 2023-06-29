package com.aqua.prod.impl;

import com.aqua.prod.api.exception.UserExistsException;
import com.aqua.prod.dao.UserDAO;
import com.aqua.prod.entity.User;
import com.aqua.prod.model.LoginBody;
import com.aqua.prod.model.RegistrationBody;
import com.aqua.prod.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private EncryptionServiceImpl encryptionService;
    private JWTServiceImpl jwtService;

    public UserServiceImpl(UserDAO userDAO, EncryptionServiceImpl encryptionService, JWTServiceImpl jwtService)
    {
        this.userDAO = userDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }


    @Override
    public String login(LoginBody loginBody)
    {
        Optional<User> optUser = userDAO.findByUserNameIgnoreCase(loginBody.getUserName());
        if (optUser.isPresent()) {
            User user = optUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }

        return null;
    }

    public User register(RegistrationBody registrationBody) throws UserExistsException
    {
        if (userDAO.findByUserNameIgnoreCase(registrationBody.getUserName()).isPresent()
                || userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()) {
            throw new UserExistsException();
        }
        User user = new User();
        user.setUserName(registrationBody.getUserName());
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return userDAO.save(user);
    }
}
