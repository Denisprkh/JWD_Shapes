package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByMaxArea implements Specification<Triangle> {

    private double maxArea;
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByMaxArea(double maxArea){
        this.maxArea = maxArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        double area = triangleService.countArea(triangle);
        return area <= maxArea;
    }
}


