package ru.ivmiit.students;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentsRepository implements CrudRepository {
    private ArrayList<Student> list = new ArrayList<>();
    private List<Faculty> faculties = new LinkedList<>();

    public StudentsRepository() {
        faculties.add(Faculty.COMPUTER_SCIENCE);
        faculties.add(Faculty.MATHEMATICS);
        faculties.add(Faculty.MACHINE_LEARNING);
        faculties.add(Faculty.DESIGNER);
        faculties.add(Faculty.PRODUCT_MANAGER);
    }

    @Override
    public void add(Object object) {
        list.add((Student) object);
    }

    @Override
    public void read() {
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void update(int index, Object object) {
        list.add(index, (Student) object);
    }

    @Override
    public void delete() {
        list = new ArrayList<Student>();
    }

    public void deleteForIndex(int index) {
        list.remove(index);
    }

    public ArrayList<Student> getForFaculty(Faculty falulty) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : list) {
            if (student.getFaculty() == falulty) {
                result.add(student);
            }
        }
        return result;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public List<Faculty> getFacultyList() {
        return faculties;
    }
}
