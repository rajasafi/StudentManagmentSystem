package com.StudentManagmentSystem.service;

import com.StudentManagmentSystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    public List<Student> getAllStudents();
    public Student saveStudentForm(Student student);
    public Student getById(int id);
    public void deleteById(int id);

}
