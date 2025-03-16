package com.example.spring_boot_api_server.service;

import com.example.spring_boot_api_server.model.MongoUser;
import com.example.spring_boot_api_server.repository.MongoUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class MongoUserServiceTest {

    @Autowired
    private MongoUserRepository mongoUserRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        mongoUserRepository.deleteAll(); // 테스트 실행 전 데이터 삭제
    }

    @Test
    void testCreateAndFindUser() {
        // Given: 새로운 사용자 추가
        MongoUser user = new MongoUser(null, "Alice", 25);
        mongoUserRepository.save(user);

        // When: 저장된 사용자 조회
        List<MongoUser> users = mongoUserRepository.findAll();

        // Then: 1개만 존재해야 함
        assertEquals(1, users.size());
    }
}