package com.example.spring_boot_api_server.controller;

import com.example.spring_boot_api_server.model.MongoUser;
import com.example.spring_boot_api_server.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mongo-users")
public class MongoUserController {

    @Autowired
    private MongoUserService mongoUserService;

    @GetMapping
    public List<MongoUser> getAllUsers() {
        return mongoUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<MongoUser> getUserById(@PathVariable String id) {
        return mongoUserService.getUserById(id);
    }

    @PostMapping
    public MongoUser createUser(@RequestBody MongoUser user) {
        return mongoUserService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        mongoUserService.deleteUser(id);
    }
}
