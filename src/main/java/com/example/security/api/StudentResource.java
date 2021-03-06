package com.example.security.api;

import com.example.security.DTO.StudentDto;
import com.example.security.service.interfaces.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get_student")
    public ResponseEntity<StudentDto> get(@RequestParam Long id) {
        return ResponseEntity.ok().body(studentService.get(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok().body(studentService.save(studentDto));
    }

    @GetMapping("/get_student_by_name_and_surname")
    public ResponseEntity<StudentDto> getStudentByNameAndSurname(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname) {
        return ResponseEntity.ok().body(studentService.getByNameAndSurname(name, surname));
    }
}
