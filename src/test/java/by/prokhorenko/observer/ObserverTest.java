package test.java.by.prokhorenko.observer;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.entity.TriangleParameters;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.observer.TriangleWareHouse;
import by.prokhorenko.shapes.service.ITriangleService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ObserverTest {

    TriangleWareHouse triangleWareHouse;
    Triangle triangle;
    Triangle triangleForChanging;
    double area;
    double perimeter;
    double areaForChanging;
    double perimeterForChanging;
    ServiceFactory serviceFactory;
    ITriangleService triangleService;
    TriangleParameters triangleParameters;
    TriangleParameters previousTriangleParameters;
    Point changer;

    @BeforeClass
    public void setUp(){
        triangleWareHouse = TriangleWareHouse.getInstance();
        triangle = new Triangle(new Point(3,4), new Point(7,9), new Point(4,3));
        triangleForChanging = new Triangle(new Point(3,4), new Point(7,9), new Point(4,3));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        changer = new Point(10,16);
        triangleService = serviceFactory.getTriangleService();
        area = triangleService.countArea(triangle);
        perimeter = triangleService.countPerimeter(triangle);
        triangleParameters = new TriangleParameters(area,perimeter);
        areaForChanging = triangleService.countArea(triangleForChanging);
        perimeterForChanging = triangleService.countPerimeter(triangleForChanging);
        previousTriangleParameters = new TriangleParameters(areaForChanging,perimeterForChanging);

    }


    @Test
    public void triangleWareHouseValuesTest(){
        TriangleParameters actual  = triangleWareHouse.getTriangleParameters(1);
        Assert.assertEquals(triangleParameters,actual);
    }

    @Test
    public void changingTriangleParametersTest(){
        triangleForChanging.setFirstTop(changer);
        TriangleParameters actual = triangleWareHouse.getTriangleParameters(2);
        Assert.assertNotEquals(previousTriangleParameters,actual);
    }


    @AfterClass
    public void tierDown(){
        triangleWareHouse = null;
        triangle = null;
        serviceFactory = null;
        triangleService = null;
        triangleParameters = null;
        changer = null;
    }


}
