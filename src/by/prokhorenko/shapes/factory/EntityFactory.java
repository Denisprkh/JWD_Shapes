package by.prokhorenko.shapes.factory;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.entity.TriangleParameters;
import by.prokhorenko.shapes.exception.RepositoryException;
import by.prokhorenko.shapes.repository.Impl.TriangleRepositoryImpl;
import by.prokhorenko.shapes.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityFactory {

    private Repository triangleRepository = TriangleRepositoryImpl.getTriangleRepository();
    private EntityFactory(){}
    private static final EntityFactory INSTANCE = new EntityFactory();
    private final static Logger log = LogManager.getLogger();
    public static EntityFactory getInstance(){
        return INSTANCE;
    }

    public Point getPoint(double x, double y){
        return new Point(x,y);
    }

    public Triangle getTriangle(Point firstTop, Point secondTop, Point thirdTop){
        Triangle triangle = new Triangle(firstTop,secondTop,thirdTop);
        try {
            triangleRepository.save(triangle);
        } catch (RepositoryException e) {
            log.info("Triangle hasn't added to repository: its null");
        }
        return triangle;
    }

    public TriangleParameters getTriangleParameters(double area, double perimeter){
        return new TriangleParameters(area,perimeter);
    }

}
