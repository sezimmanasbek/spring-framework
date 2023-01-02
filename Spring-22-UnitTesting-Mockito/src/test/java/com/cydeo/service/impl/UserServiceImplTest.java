package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testDeleteByUsername(){


        userService.deleteByUserName("mike@cdyeo.com");
//        verify that mock method got executed
        Mockito.verify(userRepository).deleteByUserName("mike@cdyeo.com");
        verify(userRepository,times(1)).deleteByUserName("mike@cdyeo.com");
        verify(userRepository,atLeastOnce()).deleteByUserName("mike@cdyeo.com");
        verify(userRepository,atLeast(1)).deleteByUserName("mike@cdyeo.com");
        verify(userRepository,atMostOnce()).deleteByUserName("mike@cdyeo.com");verify(userRepository,atLeastOnce()).deleteByUserName("mike@cdyeo.com");
        verify(userRepository,atMost(1)).deleteByUserName("mike@cdyeo.com");

        InOrder inOrder = inOrder(userRepository);
//         check the order of method executed inside mock method which we used
        inOrder.verify(userRepository).findAll();
        inOrder.verify(userRepository).deleteByUserName("mike@cdyeo.com");

    }

}
