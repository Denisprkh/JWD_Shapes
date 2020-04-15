package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByMinPerimeter implements Specification<Triangle> {

    private double minPerimeter;
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByMinPerimeter(double minPerimeter){
        this.minPerimeter = minPerimeter;
    }

    public double getMinPerimeter() {
        return minPerimeter;
    }

    public void setMinPerimeter(double minPerimeter) {
        this.minPerimeter = minPerimeter;
    }

    @Override
    public boolean specify(Triangle triangle) {
        double perimeter = triangleService.countPerimeter(triangle);

        return perimeter >= minPerimeter;
    }
}
