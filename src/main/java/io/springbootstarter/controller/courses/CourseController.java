package io.springbootstarter.controller.courses;

import io.springbootstarter.controller.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controllers in spring-boot are just basically java classes that map api request to responses
 */
@RestController // tells Spring that these class is able to handle Api requests coming into our Application
public class CourseController {

    @Autowired // marks these field as being needed for dependency injection from spring
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses") // So these route will Query our DB for all courses that belong to a
    // particular topic based on the id
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getCourses(id);
    }

    // Our Query here will look like SELECT * FROM courses WHERE id is + id
    // "localHost:3000/topics/3/courses/4" so 4 as a courseId is what we use to make queries on our Db
    @RequestMapping("/topics/{topicId}/courses/{id}")
    // tells spring that these route requires an input param and we should map that input
    // param to our @PathVariable id variable
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "/topics/{topicId}/courses")
    // maps these route to any /topics that's a POST request
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type course
        courseService.addCourse(course);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "topics/{topicId}/courses/{courseId}")
    // maps these route to any /topics/id and then updates
    // that particular course
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
        course.setTopic(new Topic(topicId, "", ""));
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type course
        courseService.updateCourse(course);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = "topics/{topicId}/courses/{id}")
    // maps these route to any /topics that's a Delete
    // request and then deletes that courses based on its id
    public void deleteCourse(@PathVariable String id) {
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type courses
        courseService.deleteCourse(id);

    }
}
