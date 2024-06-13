package com.nahudev.ToDoListApplication.repository;

import com.nahudev.ToDoListApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
}
