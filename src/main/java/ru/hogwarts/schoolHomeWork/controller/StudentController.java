package ru.hogwarts.schoolHomeWork.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schoolHomeWork.model.Student;
import ru.hogwarts.schoolHomeWork.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create (@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("{id}")
    public Student read(@PathVariable Long id){
        return studentService.read(id);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }

    @GetMapping
    public List<Student> getAllByAge(@RequestParam int age){
        return studentService.getAllByAge(age);
    }
    @GetMapping
    public List<Student> findByAgeBetween(int from, int to){
        return studentService.findByAgeBetween(from, to);
    }

}
