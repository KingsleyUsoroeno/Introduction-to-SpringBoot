package io.springbootstarter.student.service;

import io.springbootstarter.student.dao.StudentDao;
import io.springbootstarter.student.entity.Student;
import io.springbootstarter.student.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public Student getStudentById(int id) {
        return studentDao.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Student findStudentByParentsEmail(String email) {
        return studentDao.findByParentsEmail(email).orElseThrow(ResourceNotFoundException::new);
    }

    public void createStudent(Student student) {
        studentDao.save(student);
    }

    public Student updateStudent(int id, Student newStudent) {
        Student student = studentDao.findById(id).orElseThrow(ResourceNotFoundException::new);
        student.setName(newStudent.getName());
        student.setCourse(newStudent.getCourse());
        student.setParentsEmail(newStudent.getParentsEmail());
        return studentDao.save(student);
    }

    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }
}
