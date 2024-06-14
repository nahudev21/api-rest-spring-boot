package com.nahudev.ToDoListApplication.repository;

import com.nahudev.ToDoListApplication.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u where u.username = ?1")
    public Optional<UserEntity> findByUsername(String username);

}
