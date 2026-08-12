package com.cjc.controller;

import com.cjc.model.Student;
import com.cjc.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Home page navigation
    @GetMapping({"/", "/home"})
    public String showHomePage() {
        return "home";
    }

    // Show registration form with empty student command object
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        if (!model.containsAttribute("student")) {
            model.addAttribute("student", new Student());
        }
        return "register";
    }

    // Process student registration (CREATE)
    @PostMapping("/register")
    public String registerStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            @RequestParam(value = "selectedSubjects", required = false) String[] selectedSubjects,
            Model model) {

        // Check for duplicate email
        if (student.getEmail() != null && !student.getEmail().trim().isEmpty()) {
            Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
            if (existingStudent.isPresent()) {
                result.rejectValue("email", "error.student", "Email is already registered. Please login or use a different email.");
            }
        }

        // Return to form if validation errors exist
        if (result.hasErrors()) {
            return "register";
        }

        // Set subject array if selected
        student.setSubjectsFromArray(selectedSubjects);

        // Save new student to local database
        studentRepository.save(student);

        model.addAttribute("successMessage", "Registration completed successfully! Please login with your credentials.");
        return "login";
    }

    // List all registered students (READ)
    @GetMapping("/students")
    public String listAllStudents(Model model) {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("students", studentList);
        return "list";
    }

    // View specific student profile (READ)
    @GetMapping("/student/{id}")
    public String viewStudentProfile(@PathVariable("id") Long id, Model model) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "welcome";
        } else {
            model.addAttribute("errorMessage", "Student record not found.");
            return "redirect:/students";
        }
    }

    // Show edit student form (UPDATE)
    @GetMapping("/student/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "edit";
        } else {
            model.addAttribute("errorMessage", "Student not found with ID: " + id);
            return "redirect:/students";
        }
    }

    // Process student update (UPDATE)
    @PostMapping("/student/update")
    public String updateStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            @RequestParam(value = "selectedSubjects", required = false) String[] selectedSubjects,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Check duplicate email if modified
        if (student.getEmail() != null && !student.getEmail().trim().isEmpty()) {
            Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
            if (existingStudent.isPresent() && !existingStudent.get().getId().equals(student.getId())) {
                result.rejectValue("email", "error.student", "Email is already taken by another account.");
            }
        }

        if (result.hasErrors()) {
            return "edit";
        }

        student.setSubjectsFromArray(selectedSubjects);
        studentRepository.save(student);

        redirectAttributes.addFlashAttribute("successMessage", "Student details updated successfully!");
        return "redirect:/students";
    }

    // Delete student record (DELETE)
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Student record deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Student record not found!");
        }
        return "redirect:/students";
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Process student login
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        Optional<Student> studentOpt = studentRepository.findByEmailAndPassword(email, password);

        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "welcome";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
            return "login";
        }
    }

    // Process user logout
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session != null) {
            session.invalidate();
        }
        redirectAttributes.addFlashAttribute("successMessage", "You have been logged out successfully.");
        return "redirect:/login";
    }
}