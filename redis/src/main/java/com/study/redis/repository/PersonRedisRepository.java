package com.study.redis.repository;

import com.study.redis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {

}
