package com.example.spring_boot_api_server.service;

import com.example.spring_boot_api_server.model.PostgresUser;
import com.example.spring_boot_api_server.repository.PostgresUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostgresUserService {

    @Autowired
    private PostgresUserRepository postgresUserRepository;

    public List<PostgresUser> getAllUsers() {
        return postgresUserRepository.findAll();
    }

    public Optional<PostgresUser> getUserById(Long id) {
        return postgresUserRepository.findById(id);
    }

    public PostgresUser createUser(PostgresUser user) {
        return postgresUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        postgresUserRepository.deleteById(id);
    }
}
