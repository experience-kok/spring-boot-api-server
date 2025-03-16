package com.example.spring_boot_api_server.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "mongo_users") // MongoDB 컬렉션 지정
public class MongoUser {

    @Id
    private String id;  // MongoDB의 기본 키는 String 타입

    private String name;
    private int age;

    // 기본 생성자 (필수)
    public MongoUser() {}

    // 올바른 생성자
    public MongoUser(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
