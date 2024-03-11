package com.tasksApp.controllers;

import com.tasksApp.domain.tasks.Task;
import com.tasksApp.domain.tasks.TaskRecord;
import com.tasksApp.services.TasksServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    private TasksServices tasksServices;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = tasksServices.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody @Valid TaskRecord data) {
        tasksServices.createTask(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable String taskId,@RequestBody @Valid TaskRecord newData) {
        tasksServices.updateTask(taskId, newData);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId) {
        tasksServices.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}
