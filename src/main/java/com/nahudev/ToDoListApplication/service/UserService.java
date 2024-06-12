package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.User;
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
    public void createdUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(Long id_user, User user) {
        User userEdited = new User();
        Optional<User> userFound = this.getUser(id_user);
        userEdited = userFound.get();

        userEdited.setName(user.getName());
        userEdited.setLastName(user.getLastName());
        userEdited.setBirthdate(user.getBirthdate());
        userEdited.setEmail(user.getEmail());

        userRepository.save(userEdited);

    }

    @Override
    public void deleteUser(Long id_user) {
        userRepository.deleteById(id_user);
    }

    @Override
    public Optional<User> getUser(Long id_user) {
        return userRepository.findById(id_user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
