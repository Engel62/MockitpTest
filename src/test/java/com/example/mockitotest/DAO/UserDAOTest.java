package com.example.mockitotest.DAO;

import com.example.mockitotest.DAO.impl.UserDaoImpl;
import com.example.mockitotest.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDAOTest {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Test
    @DisplayName("Возврат пользователя по имени")
    public void shouldReturnUserByName() {
        Assertions.assertEquals(new User("Алиса", 24), userDaoImpl.getUserByName("Алиса"),
                "Имя пользователя должно быть в списке");
    }

    @Test
    @DisplayName("Возвращает значение not null, если имя пользователя существует в списке")
    public void shouldReturnNotNullWhenUserNameExist() {
        Assertions.assertNotNull(userDaoImpl.getUserByName("Иван"),
                "Имя пользователя должно присутствовать в списке");
    }
}
