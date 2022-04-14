package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
