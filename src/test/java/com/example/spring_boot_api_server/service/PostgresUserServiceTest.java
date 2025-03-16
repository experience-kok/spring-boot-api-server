package com.example.spring_boot_api_server.service;

import com.example.spring_boot_api_server.model.PostgresUser;
import com.example.spring_boot_api_server.repository.PostgresUserRepository;
import com.example.spring_boot_api_server.service.PostgresUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostgresUserServiceTest {

    @Autowired
    private PostgresUserService postgresUserService;

    @Autowired
    private PostgresUserRepository postgresUserRepository;

    @Test
    public void testCreateAndFindUser() {
        // Given: 새로운 유저 생성
        PostgresUser user = new PostgresUser();
        user.setName("TestUser");
        user.setAge(30);

        // When: 유저 저장CREATE TABLE postgres_users (
        //    id SERIAL PRIMARY KEY,
        //    name VARCHAR(255) NOT NULL,
        //    age INT NOT NULL
        //);
        PostgresUser savedUser = postgresUserService.createUser(user);

        // Then: 저장된 유저 검증
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("TestUser");

        // 데이터 조회 테스트
        List<PostgresUser> users = postgresUserService.getAllUsers();
        assertThat(users).isNotEmpty();
    }
}
