package com.nahudev.ToDoListApplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_user;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "fecha_nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birthdate;

    @NotBlank
    @Size(max = 30)
    private String username;

    @Email
    @NotBlank
    @Size(max = 80)
    @Column(name = "email")
    private String email;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<Task> listTasks;

    public UserEntity() {
    }

    public UserEntity(Long id_user, String name, String lastName, LocalDate birthdate, String username,
                      String email, String password, Set<RoleEntity> roles, List<Task> listTasks) {
        this.id_user = id_user;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.listTasks = listTasks;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", listTasks=" + listTasks +
                '}';
    }
}
