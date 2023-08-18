package com.aqua.prod.serviceImpl;

import com.aqua.prod.service.EncryptionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {
    @Value("${encryption.salt.rounds}")
    private int saltRounds;
    private String salt;

    @PostConstruct
    public void postConst()
    {
        salt = BCrypt.gensalt(saltRounds);
    }

    @Override
    public String encryptPassword(String password)
    {
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public boolean verifyPassword(String password, String hash)
    {
        return BCrypt.checkpw(password, hash);
    }
}
