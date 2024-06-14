package com.nahudev.ToDoListApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nahudev.ToDoListApplication.model.RoleEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private String name;
    private String lastName;
    private LocalDate birthdate;
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles;

}
