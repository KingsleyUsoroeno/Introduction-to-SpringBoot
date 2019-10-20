package io.springbootstarter.student.controller;

import io.springbootstarter.student.entity.Student;
import io.springbootstarter.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*Fix my Post and PUT routes*/
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student) {
        System.out.println("post request student is " + student);
        studentService.createStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
