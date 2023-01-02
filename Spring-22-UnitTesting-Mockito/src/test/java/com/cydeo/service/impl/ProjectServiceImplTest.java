package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void testGetByProjectCode(){
//        Given
        Project project = new Project();
        ProjectDTO projectDto = new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDto);

//        When
       ProjectDTO projectDTO1 = projectService.getByProjectCode("PRO1");
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

//        Then
        assertNotNull(projectDTO1);
        assertEquals(projectDTO1, projectDto);


    }
    @Test
    void getByProjectCodeExceptionTest(){
        when(projectRepository.findByProjectCode("PRO1")).thenThrow(new RuntimeException("Project Not Found"));
   Throwable ex = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode("PRO1"));

   assertEquals(ex.getMessage(),"Project Not Found");

    }

    @Test
    void saveTest(){
        Project project = new Project();
        ProjectDTO projectDto = new ProjectDTO();

        when(projectMapper.convertToEntity(projectDto)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDto);
        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));

    }
}
