package com.example.mockitotest.service;

import com.example.mockitotest.DAO.UserDao;
import com.example.mockitotest.model.User;
import com.example.mockitotest.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    User petr = new User("Петр", 20);
    User dmitriy = new User("Дмитрий", 32);

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("Проверьте, существует ли пользователь в списке")
    public void shouldCheckIfUserExist() {
        when(userDaoMock.checkUserExist(petr)).thenReturn(true);
        Assertions.assertTrue(userServiceImpl.checkUserExist(petr));
    }

    @Test
    @DisplayName("Проверьте, не существует ли пользователь в списке")
    public void shouldCheckIfUserNotExist() {
        when(userDaoMock.checkUserExist(dmitriy)).thenReturn(false);
        Assertions.assertFalse(userServiceImpl.checkUserExist(dmitriy));
    }
}
