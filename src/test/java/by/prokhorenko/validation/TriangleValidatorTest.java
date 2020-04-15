package test.java.by.prokhorenko.validation;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.validation.TriangleValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleValidatorTest {
    TriangleValidator triangleValidator;
    Point pointOne;
    Point pointTwo;
    Point pointThree;
    String correctData;
    String incorrectData;

    @BeforeClass
    public void setUp(){
        triangleValidator = new TriangleValidator();
        pointOne = new Point(1,2);
        pointTwo = new Point(2,3);
        pointThree = new Point(3,4);
        correctData = "2.3 4.5 2 12 21 4";
        incorrectData = "2. 2 d 12 312 1";
    }

    @Test
    public void pointsAreOnLineTest(){
        boolean actual = triangleValidator.pointsAreOnLine(pointOne,pointTwo,pointThree);
        Assert.assertTrue(actual);
    }

    @Test
    public void dataStringIsCorrectTest(){
        boolean actual = triangleValidator.dataStringIsCorrect(correctData);
        Assert.assertTrue(actual);
    }

    @Test
    public void dataStringIsCorrectTestExpectedFalse() {
        boolean actual = triangleValidator.dataStringIsCorrect(incorrectData);
        Assert.assertFalse(actual);
    }

    @AfterClass
    public void tierDown(){
        triangleValidator = null;
        pointOne = null;
        pointTwo = null;
        pointThree = null;
        correctData = null;
        incorrectData = null;
    }

}
