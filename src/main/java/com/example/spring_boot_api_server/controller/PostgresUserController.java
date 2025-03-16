package com.example.spring_boot_api_server.controller;

import com.example.spring_boot_api_server.model.PostgresUser;
import com.example.spring_boot_api_server.service.PostgresUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postgres-users")
public class PostgresUserController {

    @Autowired
    private PostgresUserService postgresUserService;

    @GetMapping
    public List<PostgresUser> getAllUsers() {
        return postgresUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<PostgresUser> getUserById(@PathVariable Long id) {
        return postgresUserService.getUserById(id);
    }

    @PostMapping
    public PostgresUser createUser(@RequestBody PostgresUser user) {
        return postgresUserService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        postgresUserService.deleteUser(id);
    }
}
