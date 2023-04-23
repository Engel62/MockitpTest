package com.example.mockitotest.service.impl;

import com.example.mockitotest.DAO.UserDao;
import com.example.mockitotest.model.User;
import com.example.mockitotest.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUserExist(User user) {
        return userDao.checkUserExist(user);
    }
}
