package com.testproject.testproject.domain.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserControllerTest {

    @Mock
    UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUsers() {
        userController.saveUsers();
        Mockito.verify(userController, Mockito.times(1)).saveUsers();
    }
}
