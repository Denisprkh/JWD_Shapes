package test.java.by.prokhorenko.reader;

import by.prokhorenko.shapes.exception.ReaderException;
import by.prokhorenko.shapes.reader.ITriangleReader;
import by.prokhorenko.shapes.reader.impl.FileTriangleReader;
import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class FileTriangleReaderTest {

    ITriangleReader triangleReader;
    List <Triangle> expectedTriangles;
    String linkToTesFile;

    @BeforeClass
    public void setUp(){
        expectedTriangles = new ArrayList<>();
        triangleReader = new FileTriangleReader();
        linkToTesFile = "src//test//java//resources//FileTriangleReaderTest.txt";
        Triangle triangle = new Triangle(1, new Point(2,4), new Point(3,4), new Point(6,5));
        Triangle triangleTwo = new Triangle(2, new Point(5,9), new Point(7,8), new Point(3,2));
        expectedTriangles.add(triangle);
        expectedTriangles.add(triangleTwo);

    }



    @Test
    public void readTrianglesTest() throws  ReaderException {
        List<Triangle> actualTriangles = triangleReader.readTriangles(linkToTesFile);
        assertEquals(actualTriangles,expectedTriangles);
    }

    @AfterClass
    public void tierDown(){
        expectedTriangles = null;
        triangleReader = null;
    }


}
