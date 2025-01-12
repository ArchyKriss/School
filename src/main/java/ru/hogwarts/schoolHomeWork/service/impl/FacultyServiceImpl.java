package ru.hogwarts.schoolHomeWork.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolHomeWork.model.Faculty;
import ru.hogwarts.schoolHomeWork.repository.FacultyRepository;
import ru.hogwarts.schoolHomeWork.service.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty create(Faculty faculty) {

        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty read(Long facultyId) {

        return facultyRepository.findById(facultyId).orElse(null);
    }

    @Override
    public Faculty update(Long facultyId, Faculty faculty) {

        Faculty facultyFromDb = facultyRepository.findById(facultyId)
                .orElseThrow(IllegalArgumentException::new);
        facultyFromDb.setName(faculty.getName());
        facultyFromDb.setColor(faculty.getColor());

        return facultyRepository.save(facultyFromDb);
    }

    @Override
    public void delete(Long facultyId) {

        facultyRepository.deleteById(facultyId);


    }

    @Override
    public List<Faculty> getAllByColor(String color) {
        return facultyRepository.findAll()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .toList();
    }
}
