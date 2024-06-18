package com.nahudev.ToDoListApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {
    @GetMapping("/sinseguridad")
    public String sinseguridad() {
        return "Sin seguridad";
    }

    @GetMapping("/conseguridad")
    public String conseguridad() {
        return "con seguridad";
    }
}
