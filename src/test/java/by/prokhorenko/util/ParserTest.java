package test.java.by.prokhorenko.util;

import by.prokhorenko.shapes.exception.UtilException;
import by.prokhorenko.shapes.util.parser.Parser;
import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    Parser parser;
    List <Point> expectedPoints;
    String data;
    Triangle expectedTriangle;
    String incorrectData;
    String incorrectDataTwo;

    @BeforeClass
    public void setUp(){
        parser = new Parser();
        expectedPoints = new ArrayList<>();
        Point firstTop = new Point(2,1);
        Point secondTop = new Point(2,5);
        Point thirdTop = new Point(5,1);
        expectedPoints.add(firstTop);
        expectedPoints.add(secondTop);
        expectedPoints.add(thirdTop);
        expectedTriangle = new Triangle(1,firstTop,secondTop,thirdTop);
        data = "2 1 2 5 5 1";
        incorrectData = null;
        incorrectDataTwo = "1 1 1 1 1 1";
    }

    @Test
    public void parsePointFromStringTest() throws  UtilException {

            List <Point> actualPoints = parser.parsePointFromString(data);
            assertEquals(expectedPoints,actualPoints);
    }
    @Test(expectedExceptions = UtilException.class)
    public void parsePointFromStringTestException() throws  UtilException {
        List <Point> actualPoints = parser.parsePointFromString(incorrectData);
        assertEquals(expectedPoints,actualPoints);
    }

    @Test
    public void parseTriangleFromStringTest() throws UtilException {
            Triangle actualTriangle = parser.parseTriangleFromString(data);
            assertEquals(expectedTriangle,actualTriangle);
    }

    @Test(expectedExceptions = UtilException.class)
    public void parseTriangleFromStringTestException() throws  UtilException {
        Triangle actualTriangle = parser.parseTriangleFromString(incorrectDataTwo);
        assertEquals(expectedTriangle,actualTriangle);
    }

    @AfterClass
    public void tierDown(){
        parser = null;
        expectedPoints = null;
        expectedTriangle = null;
        incorrectData = null;
        incorrectDataTwo = null;
    }
}
