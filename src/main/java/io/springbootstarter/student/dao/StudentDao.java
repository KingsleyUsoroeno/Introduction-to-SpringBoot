package io.springbootstarter.student.dao;

import io.springbootstarter.student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * these would be a class that helps us connects to a data center for either queering or storing data
 */
@Repository // tells spring to helps us instantiate these class without us having to do it our self's
public interface StudentDao extends MongoRepository<Student, Integer> {

    /*Our own custom Query Methods
     **/
    Optional<Student> findByParentsEmail(String parentsEmail);

    List<Student> findByName(String... names);
}


