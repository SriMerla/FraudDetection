package com.example.demotopics;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface TopicRepository extends CrudRepository<Topic, String> {
}
