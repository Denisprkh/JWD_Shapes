package test.java.by.prokhorenko.util;

import by.prokhorenko.shapes.exception.UtilException;
import by.prokhorenko.shapes.reader.util.FileUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class FileUtilTest {

    List<String> expectedReadStrings;
    String linkToTestFile;

    @BeforeClass
    public void setUp(){
        linkToTestFile = "src//test//java//by.prokhorenko.shapes.resources//ReaderTest.txt";
        expectedReadStrings = new ArrayList<>();
        expectedReadStrings.add("2 3 5 6 8 9");
        expectedReadStrings.add("3 4 5 1 3 1");
    }

    @Test
    public void readStringsFromFileTest(){
        List<String> actual;
        try {
            actual = FileUtil.readStringsFromFile(linkToTestFile);
            assertEquals(expectedReadStrings,actual);
        } catch ( UtilException e) {

        }
    }

    @AfterClass
    public void tierDown(){
        expectedReadStrings = null;
        linkToTestFile = null;
    }
}
