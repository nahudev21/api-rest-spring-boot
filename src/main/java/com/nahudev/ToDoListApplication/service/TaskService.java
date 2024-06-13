package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.Task;
import com.nahudev.ToDoListApplication.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void editTask(Long id_task, Task task) {
        Optional<Task> taskFound = this.getTask(id_task);
        Task taskEdited = new Task();
        taskEdited = taskFound.get();

        taskEdited.setTitle(task.getTitle());
        taskEdited.setDescription(task.getDescription());
        taskEdited.setCreationDate(task.getCreationDate());
        taskEdited.setState(task.getState());
        taskEdited.setUser(task.getUser());

        taskRepository.save(taskEdited);

    }

    @Override
    public void deleteTask(Long id_task) {
        taskRepository.deleteById(id_task);
    }

    @Override
    public Optional<Task> getTask(Long id_task) {
        return taskRepository.findById(id_task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
