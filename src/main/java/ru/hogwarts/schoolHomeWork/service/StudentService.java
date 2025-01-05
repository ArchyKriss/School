package ru.hogwarts.schoolHomeWork.service;

import ru.hogwarts.schoolHomeWork.model.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    Student read(Long studentId);

    Student update(Long studentId, Student student);

    void delete(Long studentId);

    List<Student> getAllByAge(int age);
}
