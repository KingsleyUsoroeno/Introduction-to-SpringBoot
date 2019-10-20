package io.springbootstarter.controller.courses;

import io.springbootstarter.controller.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * in spring the concept of business service are usually Singletons when the application starts up
 * Spring creates an instance of these service and keeps it in memory which allows us to inject these
 * service into our classes for each use without creating an instance of it
 */
@Service
public class CourseService {

    @Autowired // injects the courses repository into our Service Class
    private CourseRepository courseRepository;

    public List<Course> getCourses(String id) {
        return new ArrayList<>(courseRepository.findByTopicId(id));
    }

    public Course getCourse(String id) {
        if (courseRepository.findById(id).isPresent()) {
            return courseRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

}
