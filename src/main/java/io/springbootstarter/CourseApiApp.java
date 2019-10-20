package io.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // These Annotation tells SpringBoot that these is the starting point of our
// Spring Application
public class CourseApiApp {
    public static void main(String[] args) {
        SpringApplication.run(CourseApiApp.class, args);
        /*Enables us to run start up our Spring Application*/
    }
}
