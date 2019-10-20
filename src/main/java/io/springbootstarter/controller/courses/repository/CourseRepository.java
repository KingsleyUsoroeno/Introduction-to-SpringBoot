package io.springbootstarter.controller.courses.repository;

import io.springbootstarter.controller.courses.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findByTopicId(String id); // how we create our own custom query using jpa
    // we follow a particular standard which is findBy//then the columnName/FieldName// then the

}
