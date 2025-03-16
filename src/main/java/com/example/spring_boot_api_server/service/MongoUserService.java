package com.example.spring_boot_api_server.service;

import com.example.spring_boot_api_server.model.MongoUser;
import com.example.spring_boot_api_server.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoUserService {

    @Autowired
    private MongoUserRepository mongoUserRepository;

    public List<MongoUser> getAllUsers() {
        return mongoUserRepository.findAll();
    }

    public Optional<MongoUser> getUserById(String id) {
        return mongoUserRepository.findById(id);
    }

    public MongoUser createUser(MongoUser user) {
        return mongoUserRepository.save(user);
    }

    public void deleteUser(String id) {
        mongoUserRepository.deleteById(id);
    }
}
