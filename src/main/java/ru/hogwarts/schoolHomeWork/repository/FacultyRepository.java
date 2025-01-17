package ru.hogwarts.schoolHomeWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schoolHomeWork.model.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
