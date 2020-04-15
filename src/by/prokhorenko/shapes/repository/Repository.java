package by.prokhorenko.shapes.repository;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.RepositoryException;

import java.util.List;

public interface Repository<T> {

    boolean delete(T obj) throws RepositoryException;
    boolean save (T obj) throws RepositoryException;
    boolean update(T obj) throws RepositoryException;
    T get(int index);
    int size();
    List<Triangle> query(Specification specification);

}
