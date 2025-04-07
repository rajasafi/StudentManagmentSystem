package com.StudentManagmentSystem.controller;

import com.StudentManagmentSystem.entity.Student;
import com.StudentManagmentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home() {
        return "home"; // this will go to view page to call home.html from template
    }
    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // this will go to view page to call students.html
    }

    @GetMapping("/students/addNew")
    public String createStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "createStudent"; // this will go to view page to call createStudent.html
    }

    @PostMapping("/students")
    public String saveStudentForm(@ModelAttribute("student") Student student){
        studentService.saveStudentForm(student);
        return "redirect:/students"; // this will redirect to the students page after save
    }

    @GetMapping("/students/update/{id}")
    public String editStudentForm(@PathVariable int id, Model model){
        model.addAttribute("student", studentService.getById(id));
        return "editStudent"; // this will go to view page to call editStudent.html
    }

    @PostMapping("/students/update/{id}")  // this is to handle the form submission after update button is clicked in editStudent.html page  // @PathVariable int id is used to get the id of the student that needs to be updated  // @ModelAttribute("student") Student student is used to bind the form data to the Student object for update operation  // after update, it will redirect to the students page  // @PostMapping is used for form submission in POST method  // redirect
    public String updateStudent(@PathVariable int id ,@ModelAttribute("student") Student student){
        student.setId(id);
        studentService.saveStudentForm(student);
        return "redirect:/students"; // this will redirect to the students page after update
    }

    @GetMapping("/students/{id}") // this is to handle the form submission after delete button is clicked in deleteStudent.html page  // @PathVariable int id is used to get the id of the student that needs to be deleted  // deleteById is the method to delete the student by its id  // after delete, it will redirect to the students page  // @GetMapping is used for the HTTP GET method  // delete is the method to delete the student by its id  //
    public String deleteById(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/students"; // this will redirect to the students page after delete  // @PathVariable int id is used to get the id of the student that needs to be deleted  // redirect is used to redirect to the specified page after deletion  // @GetMapping is used for the HTTP GET method  // deleteById is the method to delete the student by its id  // after delete, it will redirect to the students page  // this method is used in the deleteStudent.html page
    }
}
