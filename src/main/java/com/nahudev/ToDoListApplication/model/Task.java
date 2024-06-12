package com.nahudev.ToDoListApplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Tareas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long id_task;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha_creacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference("id_user")
    private User user;

    public Task() {
    }

    public Task(Long id_task, String title, String description,
                LocalDate creationDate, String state, User user) {
        this.id_task = id_task;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.state = state;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id_task=" + id_task +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", state='" + state + '\'' +
                ", user=" + user +
                '}';
    }
}
