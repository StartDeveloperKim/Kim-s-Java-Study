package com.study.redis.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@ToString
@Getter
@RedisHash(value = "people", timeToLive = 30)
public class Person {

    @Id
    private String id;

    private final String name;
    private final Integer age;
    private final LocalDateTime createAt;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createAt = LocalDateTime.now();
    }
}
