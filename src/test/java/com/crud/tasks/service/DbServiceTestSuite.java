package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DbServiceTestSuite {


    @Autowired
    DbService service;

    @Test
    void shouldGetTask() throws TaskNotFoundException {
        //Given
        Task task = new Task( "titleTest", "contentTest");
        service.saveTask(task);
        Long id = task.getId();

        //When
        Task resultTask = service.getTask(id);

        //Then
        assertEquals("titleTest", resultTask.getTitle());

        //CleanUp
        service.deleteTask(id);
    }

    @Test
    void shouldGetAllTasks(){
        //Given
        Task task = new Task( "titleTest", "contentTest");
        Task task2 = new Task( "titleTest2", "contentTest2");
        Task task3 = new Task( "titleTest3", "contentTest3");

        service.saveTask(task);
        service.saveTask(task2);
        service.saveTask(task3);

        Long id = task.getId();
        Long id2 = task2.getId();
        Long id3 = task3.getId();

        //When
        List<Task> resultTaskList = service.getAllTasks();

        //Then
        assertEquals(3, resultTaskList.size());

        //CleanUp
        service.deleteTask(id);
        service.deleteTask(id2);
        service.deleteTask(id3);
    }

    @Test
    void shouldDeleteTask(){
        //Given
        Task task = new Task( "titleTest", "contentTest");
        Task task2 = new Task( "titleTest2", "contentTest2");
        Task task3 = new Task( "titleTest3", "contentTest3");

        service.saveTask(task);
        service.saveTask(task2);
        service.saveTask(task3);

        Long id = task.getId();
        Long id2 = task2.getId();
        Long id3 = task3.getId();

        //When
        service.deleteTask(id);
        List<Task> resultTaskList = service.getAllTasks();

        //Then
        assertEquals(2, resultTaskList.size());

        //CleanUp
        service.deleteTask(id2);
        service.deleteTask(id3);
    }

     

}
