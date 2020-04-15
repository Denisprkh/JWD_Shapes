package by.prokhorenko.shapes.util.comparator;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.service.ITriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TrianglesYCoordinateComparator implements Comparator<Triangle> {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ITriangleService triangleService = serviceFactory.getTriangleService();
    private final static Logger log = LogManager.getLogger();

    @Override
    public int compare(Triangle o1, Triangle o2) {
        Point nearestPointO1 = null;
        Point nearestPointO2 = null;

            nearestPointO1 = triangleService.findNearestPointToCoordinatesBeginning(o1);
            nearestPointO2 = triangleService.findNearestPointToCoordinatesBeginning(o2);

        return (int) (nearestPointO1.getY() - nearestPointO2.getY());
    }
}
