package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.dto.CreateUserDTO;
import com.nahudev.ToDoListApplication.model.UserEntity;
import com.nahudev.ToDoListApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public void createdUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void editUser(Long id_user, UserEntity userEntity) {
        UserEntity userEntityEdited = new UserEntity();
        Optional<UserEntity> userFound = this.getUser(id_user);
        userEntityEdited = userFound.get();

        userEntityEdited.setName(userEntity.getName());
        userEntityEdited.setLastName(userEntity.getLastName());
        userEntityEdited.setBirthdate(userEntity.getBirthdate());
        userEntityEdited.setEmail(userEntity.getEmail());

        userRepository.save(userEntityEdited);

    }

    @Override
    public void deleteUser(Long id_user) {
        userRepository.deleteById(id_user);
    }

    @Override
    public Optional<UserEntity> getUser(Long id_user) {
        return userRepository.findById(id_user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
