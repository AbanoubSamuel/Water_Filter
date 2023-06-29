package com.aqua.prod.service;

import com.aqua.prod.model.LoginBody;

public interface UserService {
//    User saveUser(User user);

    String login(LoginBody loginBody);
}