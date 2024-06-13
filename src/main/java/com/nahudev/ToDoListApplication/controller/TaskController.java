package com.nahudev.ToDoListApplication.controller;

import com.nahudev.ToDoListApplication.model.Task;
import com.nahudev.ToDoListApplication.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) throws URISyntaxException {
        if (task.getTitle().isBlank() || task.getDescription().isBlank() || task.getState().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        taskService.createTask(task);
        return ResponseEntity.created(new URI("/tasks/create")).build();
    }

    @PutMapping("/edit/{id_task}")
    public ResponseEntity<?> editTask(@PathVariable Long id_task, @RequestBody Task task) {
        Optional<Task> taskFound = taskService.getTask(id_task);
        if (taskFound.isPresent()) {
            taskService.editTask(id_task, task);
            return ResponseEntity.ok("Tarea actualizada correctamente!");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id_task}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id_task) {
        if (id_task != null) {
            taskService.deleteTask(id_task);
            return ResponseEntity.ok("Tarea eliminada correctamente!");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getTask/{id_task}")
    @ResponseBody
    public ResponseEntity<?> getTask(@PathVariable Long id_task) {
        Optional<Task> taskFound = taskService.getTask(id_task);
        if (taskFound.isPresent()) {
            return ResponseEntity.ok(taskFound);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> taskList = taskService.getAllTasks();
        if (taskList != null) {
            return ResponseEntity.ok(taskList);
        }

        return ResponseEntity.badRequest().build();
    }

}
