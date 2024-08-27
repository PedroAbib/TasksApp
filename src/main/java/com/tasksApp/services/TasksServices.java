package com.tasksApp.services;

import com.tasksApp.domain.tasks.Task;
import com.tasksApp.domain.tasks.TaskRecord;
import com.tasksApp.domain.tasks.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServices {
    @Autowired
    private TasksRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(TaskRecord data) {
        Task newTask = new Task(data);
        return repository.save(newTask);
    }

    public void updateTask(String taskId, TaskRecord newData) {
        //Optional is used because this object may or not exist when the findById searches for requested item
        Optional<Task> existingTaskOptional = repository.findById(taskId);

        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setName(newData.name());
            repository.save(existingTask);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void deleteTask(String taskId) {
        Optional<Task> existingTaskOptional = repository.findById(taskId);

        if (existingTaskOptional.isPresent()) {
            repository.deleteById(taskId);
        } else {
            throw new EntityNotFoundException();
        }
    }


}
