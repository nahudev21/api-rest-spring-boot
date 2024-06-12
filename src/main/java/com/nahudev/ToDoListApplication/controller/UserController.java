package com.nahudev.ToDoListApplication.controller;

import com.nahudev.ToDoListApplication.model.User;
import com.nahudev.ToDoListApplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) throws URISyntaxException {

        if (user.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        userService.createdUser(user);
        return ResponseEntity.created(new URI("/users/created")).build();

    }

    @PutMapping("/edit/{id_user}")
    public ResponseEntity<?> editUser(@PathVariable Long id_user,@RequestBody User user) {

        Optional<User> userFound = userService.getUser(id_user);
        if (userFound.isPresent()) {
            userService.editUser(id_user, user);
            return ResponseEntity.ok("Usuario editado exitosamente!");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id_user}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id_user) {

        if (id_user != null) {
            userService.deleteUser(id_user);
            return ResponseEntity.ok("Usuario eliminado exitosamente!");
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/getUser/{id_user}")
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable Long id_user) {

        Optional<User> userFound = userService.getUser(id_user);

        if (userFound.isPresent()) {
            return ResponseEntity.ok(userFound);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseEntity<?> getAllUsers() {

        List<User> userList = userService.getAllUsers();

        if (userList != null) {
            return ResponseEntity.ok(userList);
        }

        return ResponseEntity.badRequest().build();
    }

}
