package com.example.mockitotest.DAO;

import com.example.mockitotest.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String userName);

    List<User> findAllUsers();

    boolean checkUserExist(User user);
}

