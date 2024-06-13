package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    public void createTask(Task task);

    public void editTask(Long id_task, Task task);

    public void deleteTask(Long id_task);

    public Optional<Task> getTask(Long id_task);

    public List<Task> getAllTasks();

}
