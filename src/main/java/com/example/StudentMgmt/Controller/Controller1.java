package com.example.StudentMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.StudentMgmt.PathModel.PathModel;
import com.example.StudentMgmt.Repositary.Repositary;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Controller1 {

    @Autowired
    private Repositary repo;

    @GetMapping("/")
    public String loginPage() {
        return "login"; 
    }
    @PostMapping("/dummyLogin")
    public String dummyLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("shiyama".equals(username) && "root".equals(password)) {
            request.getSession().setAttribute("user", "shiyama");
            return "redirect:/add"; 
        } else {
            request.setAttribute("error", "Invalid credentials");
            return "login"; 
        }
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, HttpServletRequest request) {
        PathModel student = repo.findById(id).orElse(null);
        request.setAttribute("student", student);
        return "edit"; 
    }
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute PathModel student) {
        repo.save(student); 
        return "redirect:/view";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "redirect:/view"; 
    }
    @GetMapping("/add")
    public String addStudentForm() {
        return "NewFile";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); 
        return "redirect:/";
    }
    @GetMapping("/view")
    public String viewStudents(HttpServletRequest request) {
        List<PathModel> students = repo.findAll();
        request.setAttribute("students", students);
        return "View"; 
    }
    @PostMapping("/submit")
    public String submit(@ModelAttribute PathModel student) {
        repo.save(student);        
        return "redirect:/view";  
    }
}
