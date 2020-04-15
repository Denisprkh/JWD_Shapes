package test.java.by.prokhorenko.util;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.util.PointUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PointUtilTest {
    Point pointOne;
    Point pointTwo;

    @BeforeClass
    public void setUp(){
        pointOne = new Point(1,1);
        pointTwo = new Point(3,1);
    }

    @Test
    public void countDistanceTest(){
        double expected = 2;
        double actual = PointUtil.countDistance(pointOne,pointTwo);
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void tierDown(){
        pointTwo = null;
        pointOne = null;
    }
}
