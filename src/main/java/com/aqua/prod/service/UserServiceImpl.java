package com.aqua.prod.service;

import com.aqua.prod.entity.Users;
import com.aqua.prod.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users getUser(Long id)
    {
        Optional<Users> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public Users getUser(String email)
    {
        Optional<Users> user = userRepository.findByEmail(email);
        return unwrapUser(user, 404L);
    }

    @Override
    public void saveUser(Users user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    static Users unwrapUser(Optional<Users> entity, Long id)
    {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
