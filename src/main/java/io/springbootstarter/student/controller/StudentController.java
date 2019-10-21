package io.springbootstarter.student.controller;

import io.springbootstarter.student.entity.Student;
import io.springbootstarter.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired // injects our StudentService into these class
    private StudentService studentService;

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("email/{email}")
    public Student findStudentByParentsEmail(@PathVariable String email) {
        return studentService.findStudentByParentsEmail(email);
    }

    @ResponseStatus(code = HttpStatus.CREATED, reason = "Student Created Successfully")
    @PostMapping
    public void createStudent(@RequestBody Student student) {
        System.out.println("post request student is " + student);
        studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    // the route that is responsible for handling all put/update requests to students/id(that students is)
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
