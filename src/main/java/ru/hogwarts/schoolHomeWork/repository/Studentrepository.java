package ru.hogwarts.schoolHomeWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.schoolHomeWork.model.Student;

@Repository
public interface Studentrepository extends JpaRepository <Student, Long> {

}
