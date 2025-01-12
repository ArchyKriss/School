package ru.hogwarts.schoolHomeWork.service;

import ru.hogwarts.schoolHomeWork.model.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty create(Faculty student);

    Faculty read(Long studentId);

    Faculty update(Long studentId, Faculty student);

    void delete(Long studentId);

    List<Faculty> getAllByColor(String color);

    List<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
