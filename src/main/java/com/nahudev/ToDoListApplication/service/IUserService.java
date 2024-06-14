package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public void createdUser(UserEntity userEntity);

    public void editUser(Long id_user, UserEntity userEntity);

    public void deleteUser(Long id_user);

    public Optional<UserEntity> getUser(Long id_user);

    public List<UserEntity> getAllUsers();

}
