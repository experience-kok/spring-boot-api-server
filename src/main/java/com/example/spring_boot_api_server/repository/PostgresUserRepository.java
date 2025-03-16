package com.example.spring_boot_api_server.repository;

import com.example.spring_boot_api_server.model.PostgresUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresUserRepository extends JpaRepository<PostgresUser, Long> {
}
