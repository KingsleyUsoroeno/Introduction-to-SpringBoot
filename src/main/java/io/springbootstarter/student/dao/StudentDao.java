package io.springbootstarter.student.dao;

import io.springbootstarter.student.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * these would be a class that helps us connects to a data center for either queering or storing data
 */
@Repository // tells spring to helps us instantiate these class without us having to do it our self's
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Andrew", "Java"));
                put(2, new Student(2, "James", "Flutter"));
                put(3, new Student(3, "Bond", "JavaScript"));
                put(4, new Student(4, "Samuel", "Golang"));
                put(5, new Student(5, "Blessing", "Sex Education"));
            }
        };
    }


    public Map<Integer, Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void createStudent(Student student) {
        students.put(students.size() + 1, student);
    }

    public void updateStudent(Student student) {
        Student newStudent = getAllStudents().get(student.getId());
        newStudent.setName(student.getName());
        newStudent.setCourse(student.getCourse());
        students.put(student.getId(), newStudent);
    }

    public void deleteStudent(int id) {
        students.remove(id);
    }
}
