package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByMaxPerimeter implements Specification<Triangle> {

    private double maxPerimeter;
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByMaxPerimeter(double maxPerimeter){
        this.maxPerimeter = maxPerimeter;
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

        return perimeter <= maxPerimeter;
    }
}
