package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByPerimeterRange implements Specification<Triangle> {
    private double minPerimeter;
    private double maxPerimeter;
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByPerimeterRange(double minPerimeter, double maxPerimeter){
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    public double getMinPerimeter() {
        return minPerimeter;
    }

    public void setMinPerimeter(double minPerimeter) {
        this.minPerimeter = minPerimeter;
    }

    public double getMaxPerimeter() {
        return maxPerimeter;
    }

    public void setMaxPerimeter(double maxPerimeter) {
        this.maxPerimeter = maxPerimeter;
    }



    @Override
    public boolean specify(Triangle triangle) {

        double perimeter = triangleService.countPerimeter(triangle);
        return perimeter >
                minPerimeter && perimeter < maxPerimeter;
    }
}
