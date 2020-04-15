package by.prokhorenko.shapes.util.parser;


import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.UtilException;
import by.prokhorenko.shapes.factory.EntityFactory;
import by.prokhorenko.shapes.validation.ReaderValidator;
import by.prokhorenko.shapes.validation.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final static Logger log = LogManager.getLogger();
    private static final String DATA_DELIMITER = " ";
    private TriangleValidator triangleValidator = new TriangleValidator();
    private ReaderValidator readerValidator = new ReaderValidator();
    private EntityFactory entityFactory = EntityFactory.getInstance();
    private final int FIRST_TOP = 0;
    private final int SECOND_TOP = 1;
    private final int THIRD_TOP = 2;
    private final int COORDINATE_X_OF_FIRST_TOP = 0;
    private final int COORDINATE_Y_OF_FIRST_TOP = 1;
    private final int COORDINATE_X_OF_SECOND_TOP = 2;
    private final int COORDINATE_Y_OF_SECOND_TOP = 3;
    private final int COORDINATE_X_OF_THIRD_TOP = 4;
    private final int COORDINATE_Y_OF_THIRD_TOP = 5;



    public Triangle parseTriangleFromString(String data) throws UtilException {
        if(readerValidator.isNull(data)){
            log.error("Data string for triangle is null");
            throw new UtilException("Data string is null");
        }

        List <Point> trianglesTops = parsePointFromString(data);
        Point firstTop = trianglesTops.get(FIRST_TOP);
        Point secondTop = trianglesTops.get(SECOND_TOP);
        Point thirdTop = trianglesTops.get(THIRD_TOP);

        if(triangleValidator.pointsAreOnLine(firstTop,secondTop,thirdTop)){
            log.error("Incorrect points for triangle : all points are on line");
            throw new UtilException("Incorrect points for triangle : all points are on line");
        }

        Triangle triangle = entityFactory.getTriangle(firstTop,secondTop,thirdTop);
        log.info("Triangle is created");
        return triangle;
    }

    public List<Point> parsePointFromString(String data) throws UtilException {
        if(readerValidator.isNull(data)){
            log.error("Data string for points is null");
            throw new UtilException("Data string is null");
        }
        String[] dataForPoints = data.split(DATA_DELIMITER);
        List<Point> points = new ArrayList<>();
        Point first = entityFactory.getPoint(Double.parseDouble(dataForPoints[COORDINATE_X_OF_FIRST_TOP]),
                Double.parseDouble(dataForPoints[COORDINATE_Y_OF_FIRST_TOP]));
        Point second= entityFactory.getPoint(Double.parseDouble(dataForPoints[COORDINATE_X_OF_SECOND_TOP]),
                Double.parseDouble(dataForPoints[COORDINATE_Y_OF_SECOND_TOP]));
        Point third = entityFactory.getPoint(Double.parseDouble(dataForPoints[COORDINATE_X_OF_THIRD_TOP]),
                Double.parseDouble(dataForPoints[COORDINATE_Y_OF_THIRD_TOP]));
        log.info("Points are parsed");
        points.add(first);
        points.add(second);
        points.add(third);

        return points;
    }
}

