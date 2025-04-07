package com.StudentManagmentSystem.serviceImpl;

import com.StudentManagmentSystem.entity.Student;
import com.StudentManagmentSystem.repository.Studentrepository;
import com.StudentManagmentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {
    @Autowired
    private Studentrepository Studentrepository;

    @Override
    public List<Student> getAllStudents() {
        // Implement logic to get all students from the database
        List<Student> list = Studentrepository.findAll();
        return list;
    }

    @Override
    public Student saveStudentForm(Student student) {
        return Studentrepository.save(student);
    }

    @Override
    public Student getById(int id) {
        return Studentrepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        Studentrepository.deleteById(id);
    }

}
