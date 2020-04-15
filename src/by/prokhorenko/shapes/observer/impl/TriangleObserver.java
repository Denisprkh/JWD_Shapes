package by.prokhorenko.shapes.observer.impl;

import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.entity.TriangleParameters;
import by.prokhorenko.shapes.factory.EntityFactory;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.observer.TriangleWareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.prokhorenko.shapes.observer.Observer;
import by.prokhorenko.shapes.service.ITriangleService;

public class TriangleObserver implements Observer<Triangle> {

    private TriangleWareHouse triangleWareHouse = TriangleWareHouse.getInstance();
    private EntityFactory entityFactory = EntityFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ITriangleService triangleService = serviceFactory.getTriangleService();

    @Override
    public void update(Triangle triangle) {


        double area = triangleService.countArea(triangle);
        double perimeter = triangleService.countPerimeter(triangle);
        long id = triangle.getId();
        TriangleParameters triangleParameters = entityFactory.getTriangleParameters(area,perimeter);

        triangleWareHouse.saveTriangleParameters(id,triangleParameters);

    }
}
