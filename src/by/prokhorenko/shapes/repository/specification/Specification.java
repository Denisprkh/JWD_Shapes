package by.prokhorenko.shapes.repository.specification;

public interface Specification<T>{
    boolean specify(T obj);
}
