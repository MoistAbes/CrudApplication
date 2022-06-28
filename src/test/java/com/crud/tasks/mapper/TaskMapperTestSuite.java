package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void testMapToTask(){
        //Given
        TaskDto taskDto = new TaskDto(1L, "testTitle", "testContent");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1, mappedTask.getId());
        assertEquals("testTitle", mappedTask.getTitle());
        assertEquals("testContent", mappedTask.getContent());
    }

    @Test
    void testMapToTaskDto(){
        //Given
        Task task = new Task(1L, "testTitle", "testContent");

        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1, mappedTaskDto.getId());
        assertEquals("testTitle", mappedTaskDto.getTitle());
        assertEquals("testContent", mappedTaskDto.getContent());
    }

    @Test
    void testMapToTaskDtoList(){
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        List<Task> tasks = List.of(task);

        //When
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(1, mappedTaskDtoList.size());
        assertEquals("testTitle", mappedTaskDtoList.get(0).getTitle());
    }

}
