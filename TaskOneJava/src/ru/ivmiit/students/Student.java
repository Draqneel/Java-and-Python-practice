package ru.ivmiit.students;

import java.time.LocalDate;

public class Student {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private LocalDate birthDate;
    private LocalDate currentDate = LocalDate.now();
    private String address;
    private String number;
    private Faculty faculty;
    private int course;
    private String group;

    public Student(long id, String surname, String name, String patronymic, LocalDate birthDate,
                   String address, String number, Faculty faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.number = number;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
        this.age = currentDate.getYear() - birthDate.getYear();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate.isAfter(currentDate)) {
            throw new IllegalArgumentException();
        }
        this.birthDate = birthDate;
    }

    public void setCourse(int course) {
        if (course > 4) {
            throw new IllegalArgumentException();
        }
        this.course = course;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNumber(String number) {
        if (number.length() != 11 || number.substring(0, 2) != "79") {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String toString() {
        return "Name: " + surname + " " + name + " " + patronymic + " ; he(she) is " + age + " ; address: " + address
                + " ; birthDate: " + birthDate.toString() + " ; faculty, course, group: " + faculty.toString() + " , "
                + course + " , " + group + " ; number: " + number;
    }
}
