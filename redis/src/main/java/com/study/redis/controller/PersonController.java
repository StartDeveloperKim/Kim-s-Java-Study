package com.study.redis.controller;

import com.study.redis.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public void savePerson() {
        log.info("PersonController");
        personService.addPerson();
    }
}
