package com.galvanize.xp.spring.boot;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface NameRepository extends MongoRepository<Name, String> {



}
