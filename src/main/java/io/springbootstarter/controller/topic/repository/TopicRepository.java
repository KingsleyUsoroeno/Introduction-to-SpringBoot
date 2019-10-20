package io.springbootstarter.controller.topic.repository;

import io.springbootstarter.controller.topic.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {


}
