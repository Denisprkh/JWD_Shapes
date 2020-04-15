package by.prokhorenko.shapes.service;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.ServiceException;

import java.util.List;

public interface ITriangleService {
    List<Triangle> getAllTriangles(String path) throws ServiceException;
    Triangle getTriangle(long id, String path) throws ServiceException;
    double countPerimeter(Triangle triangle) ;
    double countArea(Triangle triangle);
    boolean isRectangular(Triangle triangle);
    boolean isIsosceles(Triangle triangle);
    boolean isEquilateral(Triangle triangle);
    boolean isAcuteAngled(Triangle triangle);
    boolean isObtuse(Triangle triangle);
    Point findNearestPointToCoordinatesBeginning(Triangle triangle);
}
