package com.StudentManagmentSystem.repository;

import com.StudentManagmentSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepository extends JpaRepository<Student , Integer> {
}
