package ru.hogwarts.schoolHomeWork.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolHomeWork.model.Student;
import ru.hogwarts.schoolHomeWork.repository.Studentrepository;
import ru.hogwarts.schoolHomeWork.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Studentrepository studentrepository;

    public StudentServiceImpl(Studentrepository studentrepository){
        this.studentrepository = studentrepository;
    }

    @Override
    public Student create(Student student) {

        return studentrepository.save(student);
    }

    @Override
    public Student read(Long studentId) {

        return studentrepository.findById(studentId).orElse(null);
    }

    @Override
    public Student update(Long studentId, Student student) {

       Student studentFromDb = studentrepository.findById(studentId)
               .orElseThrow(IllegalArgumentException::new);

        studentFromDb.setName(student.getName());
        studentFromDb.setAge(student.getAge());

        return studentrepository.save(studentFromDb);
    }

    @Override
    public void delete(Long studentId) {

        studentrepository.deleteById(studentId);

    }

    @Override
    public List<Student> getAllByAge(int age) {
        return studentrepository.findAll()
                .stream()
                .filter(it -> it.getAge()==age)
                .toList();
    }

    @Override
    public List<Student> findByAgeBetween(int from, int to) {
        return studentrepository.findByAgeBetween(from, to);
    }
}
