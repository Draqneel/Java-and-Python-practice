package ru.ivmiit.students;

public interface CrudRepository {
    public void add(Object object);

    public void read();

    public void update(int index, Object object);

    public void delete();
}
