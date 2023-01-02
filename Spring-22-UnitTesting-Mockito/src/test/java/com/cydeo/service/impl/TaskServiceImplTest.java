package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Role;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskMapper taskMapper;

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceImpl taskService;
    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L,-5L})
    void findByIdTest(long arg){

        Task task = new Task();

        when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        taskService.findById(arg);

        verify(taskRepository).findById(arg);
        verify(taskMapper).convertToDTO(any(Task.class));

        verify(taskRepository,never()).findById(-5L);
    }

    @Test
    void findByIdBDDTest(){
//        Given
        Task task = new Task();

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());

//        When
        taskService.findById(anyLong());

//        Then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }


}
