package io.springbootstarter.student.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("student") // Marks these Class to a table that needs to be stored/persisted into our Database
public class Student {

    @Id
    private int id;
    private String name;
    private String course;

    @Indexed(unique = true)
    private String parentsEmail;

    public Student() {

    }

    public Student(int id, String name, String course, String parentsEmail) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.parentsEmail = parentsEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getParentsEmail() {
        return parentsEmail;
    }

    public void setParentsEmail(String parentsEmail) {
        this.parentsEmail = parentsEmail;
    }
}
