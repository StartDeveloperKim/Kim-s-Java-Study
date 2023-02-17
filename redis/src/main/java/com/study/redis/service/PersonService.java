package com.study.redis.service;

import com.study.redis.entity.Person;
import com.study.redis.repository.PersonRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRedisRepository personRedisRepository;

    public void addPerson() {
        log.info("PersonService addPerson");
        Person person = new Person("Kim", 25);
        Person savedPerson = personRedisRepository.save(person);
        Person findPerson = personRedisRepository.findById(savedPerson.getId()).get();
        System.out.println("findPerson.toString() = " + findPerson.toString());
    }
}
