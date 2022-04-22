package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
// adnotacja ta wytworzy nam konstruktor dla
// wszystkich pól oznaczonych jako final
public class DbService {

    private final TaskRepository repository;


    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task getTask(Long id){
        return repository.findTaskById(id);
    }

    public Task saveTask(final Task task){
        return repository.save(task);
    }

    public void deleteTask(final Long taskId){
        repository.deleteById(taskId);
    }

    public Task getTask2(final Long taskId) throws TaskNotFoundException {
        return repository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }

}
