package ru.hogwarts.schoolHomeWork.model;

import java.util.Objects;

public class Faculty {

    private  Long id;

    private  String name;

    private  String color;

    public Faculty(Long id, String name, String school) {
        this.id = id;
        this.name = name;
        this.color = school;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + color + '\'' +
                '}';
    }


    public String getColor() {
        return color;
    }
}
