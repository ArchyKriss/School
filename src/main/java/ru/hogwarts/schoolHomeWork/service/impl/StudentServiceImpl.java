package ru.hogwarts.schoolHomeWork.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolHomeWork.model.Student;
import ru.hogwarts.schoolHomeWork.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static Long counter = 0L;

    private final Map<Long, Student> students = new HashMap<>();

    @Override
    public Student create(Student student) {

        Long currentId = ++counter;
        student.setId(currentId);
        students.put(currentId, student);

        return student;
    }

    @Override
    public Student read(Long studentId) {

        return students.get(studentId);
    }

    @Override
    public Student update(Long studentId, Student student) {

        Student studentFromDb = students.get(studentId);
        studentFromDb.setName(student.getName());
        studentFromDb.setAge(student.getAge());

        return studentFromDb;
    }

    @Override
    public void delete(Long studentId) {

        students.remove(studentId);

    }

    @Override
    public List<Student> getAllByAge(int age) {
        return students.values()
                .stream()
                .filter(it -> it.getAge()==age)
                .toList();
    }
}
