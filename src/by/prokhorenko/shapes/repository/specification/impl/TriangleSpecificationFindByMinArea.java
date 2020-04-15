package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByMinArea implements Specification<Triangle> {

    private double minArea;
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByMinArea(double minArea){
        this.minArea = minArea;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        double area = triangleService.countArea(triangle);
        return area >= minArea;
    }
}
