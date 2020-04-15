package by.prokhorenko.shapes.repository.specification.impl;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.repository.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class TriangleSpecificationFindByFirstQuadrant implements Specification<Triangle> {

    @Override
    public boolean specify(Triangle triangle) {
        List<Point> points = new ArrayList<>();
        points.add(triangle.getFirstTop());
        points.add(triangle.getSecondTop());
        points.add(triangle.getThirdTop());

        boolean result = true;

        for(Point point : points){
            if(point.getX() <= 0 || point.getY() <= 0){
                result = false;
            }
        }

        return result;
    }
}
