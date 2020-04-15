package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleSpecificationFindByAreaRange implements Specification<Triangle> {

    private double minArea;
    private double maxArea;
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ITriangleService triangleService = serviceFactory.getTriangleService();

    public TriangleSpecificationFindByAreaRange(double minPerimeter, double maxPerimeter){
        this.minArea = minPerimeter;
        this.maxArea = maxPerimeter;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }



    @Override
    public boolean specify(Triangle triangle) {
        double area = triangleService.countPerimeter(triangle);
        return area >
                minArea && area < maxArea;
    }
}
