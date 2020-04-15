package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;

public class TriangleSpecificationFindById implements Specification<Triangle> {
    private long id;

    public TriangleSpecificationFindById(long id){
        this.id = id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }


    @Override
    public boolean specify(Triangle triangle) {
        return triangle.getId() == id;
    }
}
