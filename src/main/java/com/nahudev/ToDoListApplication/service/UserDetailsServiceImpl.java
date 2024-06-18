package com.nahudev.ToDoListApplication.service;

import com.nahudev.ToDoListApplication.model.UserEntity;
import com.nahudev.ToDoListApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements IUserService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe!"));

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
