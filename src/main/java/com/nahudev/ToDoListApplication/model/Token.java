package com.nahudev.ToDoListApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "token")
    private String token;

    @Column(name = "is_logged_out")
    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

    public Token() {

    }

    public Token(int id, String token, boolean loggedOut, UserEntity userEntity) {
        this.id = id;
        this.token = token;
        this.loggedOut = loggedOut;
        this.userEntity = userEntity;
    }

}
