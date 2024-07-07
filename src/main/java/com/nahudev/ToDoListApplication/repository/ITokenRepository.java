package com.nahudev.ToDoListApplication.repository;

import com.nahudev.ToDoListApplication.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITokenRepository extends JpaRepository<Token, Integer> {


    //List<Token> findAllTokenByUser(int userId);

    //Optional<Token> findByToken(String token);

}
