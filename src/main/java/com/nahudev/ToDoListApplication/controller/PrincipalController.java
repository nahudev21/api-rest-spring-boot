package com.nahudev.ToDoListApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {

    @GetMapping("/index")
    public String index() {
        return "Este es el index de la aplicacion";
    }

}
