package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskController taskController;


    @Test
    void shouldFetchTasks() throws Exception{
        //Given

        TaskDto taskDto = new TaskDto(1L, "test title", "test content");
        TaskDto taskDto1 = new TaskDto(2L, "test title 2", "test content 2");

        List<TaskDto> taskDtos = List.of(taskDto, taskDto1);

        ResponseEntity<List<TaskDto>> resultTasks = new ResponseEntity<>(taskDtos, HttpStatus.OK);


        when(taskController.getTasks()).thenReturn(resultTasks);

        //When & Then

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("test content")));

    }

    @Test
    void shouldFetchTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");


        ResponseEntity<TaskDto> resultTasks = new ResponseEntity<>(taskDto, HttpStatus.OK);


        when(taskController.getTask(taskDto.getId())).thenReturn(resultTasks);

        //When & Then

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("test content")));

    }

    @Test
    void shouldDeleteTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");

        ResponseEntity<Void> responseEntity = ResponseEntity.ok().build();


        when(taskController.deleteTask(taskDto.getId())).thenReturn(responseEntity);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateTask() throws Exception{
        //Given
        TaskDto updatedTaskDto = new TaskDto(1L, "test title updated", "test content updated");

        ResponseEntity<TaskDto> responseEntity = new ResponseEntity<>(updatedTaskDto, HttpStatus.OK);

        when(taskController.updateTask(any(TaskDto.class))).thenReturn(responseEntity);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedTaskDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("test title updated")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("test content updated")));
    }

    @Test
    void shouldCreateTask() throws Exception{
        //Given
        TaskDto updatedTaskDto = new TaskDto(1L, "test title", "test content");

        ResponseEntity<Void> responseEntity = ResponseEntity.ok().build();

        when(taskController.createTask(any(TaskDto.class))).thenReturn(responseEntity);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedTaskDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().isOk());
    }
}