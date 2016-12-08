package com.skitter.account.service;

import com.skitter.account.model.User;

public interface UserService {

    void save(User user);
    void delete(User user);
    User findByUsername(String username);
    User findByScreenName(String screenName);
}
