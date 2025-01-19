package ru.hogwarts.schoolHomeWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schoolHomeWork.model.Student;

import java.util.List;

@Repository
public interface Studentrepository extends JpaRepository <Student, Long> {

    List<Student> findByAgeBetween(int from, int to);

}
