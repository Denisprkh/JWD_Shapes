package test.java.by.prokhorenko.service;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.service.ITriangleService;
import by.prokhorenko.shapes.exception.ServiceException;
import by.prokhorenko.shapes.service.impl.TriangleServiceImpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class TriangleServiceImplTest {

    Triangle triangle;
    Triangle rectangularTriangle;
    Triangle isoscelesTriangle;
    Triangle equilateralTriangle;
    Triangle acuteAngledTriangle;
    Triangle obtuseTriangle;
    ITriangleService triangleService;
    List<Triangle> expectedTriangles;
    Triangle expectedTriangle;
    String linkToFile;
    final double DELTA = 0.01;

    @BeforeClass
    public void setUp(){
        triangle = new Triangle(new Point(2,1),new Point(2,3),new Point(5,1));
        triangleService = new TriangleServiceImpl();
        expectedTriangles = new ArrayList<>();
        expectedTriangle = new Triangle(9,new Point(2,4), new Point(3,4), new Point(6,5));
        expectedTriangles.add(new Triangle(7,new Point(2,4), new Point(3,4), new Point(6,5)));
        expectedTriangles.add(new Triangle(8,new Point(5,9), new Point(7,8),new Point(3,2)));
        rectangularTriangle = new Triangle(new Point(2,1), new Point(2,3), new Point(4,1));
        isoscelesTriangle = new Triangle( new Point(2,1), new Point(3,3), new Point(4,1));
        equilateralTriangle = new Triangle( new Point(0,0), new Point(1,0), new Point(0.5,0.866));
        acuteAngledTriangle = new Triangle( new Point(2,2), new Point(4,5), new Point(5,4));
        obtuseTriangle = new Triangle(new Point(3,1), new Point(4,1), new Point(9,3));
        linkToFile = "src//test//java//resources//FileTriangleReaderTest.txt";
    }



    @Test
    public void getAllTrianglesTest() throws ServiceException {
        List<Triangle> actual = triangleService.getAllTriangles(linkToFile);
        Assert.assertEquals(actual,expectedTriangles);
    }

    @Test
    public void getTriangleTest() throws ServiceException {
        Triangle actual = triangleService.getTriangle(9,linkToFile);
        Assert.assertEquals(actual,expectedTriangle);
    }



    @Test
    public void countPerimeterTest(){
        double expectedPerimeter = 8.6;
        double actualPerimeter = triangleService.countPerimeter(triangle);
        assertEquals(actualPerimeter,expectedPerimeter,DELTA);
    }

    @Test
    public void countAreaTest(){
        double expectedArea = 3;
        double actualArea = triangleService.countArea(triangle);
        assertEquals(actualArea,expectedArea,DELTA);
    }

    @Test
    public void isRectangularTest(){
        boolean actual = triangleService.isRectangular(rectangularTriangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isEquilateralTest(){
        boolean actual = triangleService.isEquilateral(equilateralTriangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isIsoscelesTest(){
        boolean actual = triangleService.isIsosceles(isoscelesTriangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isAcuteAngledTest(){
        boolean actual = triangleService.isAcuteAngled(acuteAngledTriangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isObtuseTest(){
        boolean actual = triangleService.isObtuse(obtuseTriangle);
        Assert.assertTrue(actual);
    }

    @AfterClass
    public void tierDown(){
        triangle = null;
        rectangularTriangle = null;
        isoscelesTriangle = null;
        equilateralTriangle = null;
        acuteAngledTriangle = null;
        obtuseTriangle = null;
        triangleService = null;
        expectedTriangles = null;
        expectedTriangle = null;
        linkToFile = null;
    }



}
