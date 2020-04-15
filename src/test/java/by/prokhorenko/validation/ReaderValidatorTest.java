package test.java.by.prokhorenko.validation;

import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.validation.ReaderValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReaderValidatorTest {
    ReaderValidator readerValidator;
    Triangle triangle;
    String linkToFile;

    @BeforeClass
    public void setUp(){
        readerValidator = new ReaderValidator();
        linkToFile = "src//test//java//resources//FileTriangleReaderTest.txt";
    }

    @Test
    public void isNullTest(){
        boolean actual = readerValidator.isNull(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isEmptyFileTest(){
        boolean actual = readerValidator.isEmptyFile(linkToFile);
        Assert.assertFalse(actual);
    }

    @Test
    public void fileIsExistsTest(){
        boolean actual = readerValidator.fileIsExists(linkToFile);
        Assert.assertTrue(actual);
    }

    @AfterClass
    public void tierDown(){
        readerValidator = null;
        triangle = null;
        linkToFile = null;
    }
}
