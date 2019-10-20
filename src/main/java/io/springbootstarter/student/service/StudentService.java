package io.springbootstarter.student.service;

import io.springbootstarter.student.dao.StudentDao;
import io.springbootstarter.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents().values();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
