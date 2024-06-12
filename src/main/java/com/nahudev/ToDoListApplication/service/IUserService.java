package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public void createdUser(User user);

    public void editUser(Long id_user, User user);

    public void deleteUser(Long id_user);

    public Optional<User> getUser(Long id_user);

    public List<User> getAllUsers();

}
