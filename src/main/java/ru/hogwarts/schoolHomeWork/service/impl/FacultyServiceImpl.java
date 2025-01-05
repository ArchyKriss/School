package ru.hogwarts.schoolHomeWork.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolHomeWork.model.Faculty;
import ru.hogwarts.schoolHomeWork.service.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyServiceImpl implements FacultyService {

    private static Long counter = 0L;

    private final Map<Long, Faculty> facultys = new HashMap<>();

    @Override
    public Faculty create(Faculty faculty) {

        Long currentId = ++counter;
        faculty.setId(currentId);
        facultys.put(currentId, faculty);

        return faculty;
    }

    @Override
    public Faculty read(Long facultyId) {

        return facultys.get(facultyId);
    }

    @Override
    public Faculty update(Long facultyId, Faculty faculty) {

        Faculty facultyFromDb = facultys.get(facultyId);
        facultyFromDb.setName(faculty.getName());
        facultyFromDb.setColor(faculty.getColor());

        return facultyFromDb;
    }

    @Override
    public void delete(Long facultyId) {

        facultys.remove(facultyId);

    }

    @Override
    public List<Faculty> getAllByColor(String color) {
        return facultys.values()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .toList();
    }
}
