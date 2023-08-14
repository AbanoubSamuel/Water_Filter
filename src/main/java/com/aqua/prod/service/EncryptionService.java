package com.aqua.prod.service;

public interface EncryptionService {
    String encryptPassword(String password);

    boolean verifyPassword(String password, String hash);
}
