package com.example.mockitotest.DAO.impl;

import com.example.mockitotest.DAO.UserDao;
import com.example.mockitotest.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private final List<User> userList;

    public UserDaoImpl() {
        this.userList = List.of(new User("Иван", 30), new User("Петр", 20),
                new User("Алиса", 26), new User("Елена", 37),
                new User("Анастасия", 20));
    }

    @Override
    public User getUserByName(String userName) {
        return userList.stream()
                .filter(user -> userName.equals(user.getName()))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }

    @Override
    public boolean checkUserExist(User user) {
        return userList.contains(user);
    }
}
