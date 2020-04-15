package test.java.by.prokhorenko.repository;

import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.RepositoryException;
import by.prokhorenko.shapes.repository.Impl.TriangleRepositoryImpl;
import by.prokhorenko.shapes.repository.Repository;
import by.prokhorenko.shapes.repository.specification.Specification;
import by.prokhorenko.shapes.repository.specification.impl.TriangleSpecificationFindById;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryImplTest {

    Repository triangleRepository;
    Triangle triangle;
    Triangle triangleTwo;
    Specification specification;

    @BeforeClass
    public void setUp(){
        triangleRepository = TriangleRepositoryImpl.getTriangleRepository();
        triangle = new Triangle(1,new Point(1,2), new Point(4,3), new Point(5,2));
        try {
            triangleRepository.save(triangle);
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        triangleTwo = new Triangle(1, new Point(1,2), new Point(4,13), new Point(5,2));
        specification = new TriangleSpecificationFindById(1);
    }

    @Test
    public void updateTest() throws RepositoryException {
        triangleRepository.update(triangleTwo);
        String actual = triangleRepository.toString();
        String expected = "TriangleRepositoryImpl{triangles=[Triangle{id=1, " +
                "firstTop=Point{x=1.0, y=2.0}, secondTop=Point{x=4.0, y=13.0}, thirdTop=Point{x=5.0, y=2.0}}]}";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void queryTest(){
        List<Triangle> actualTriangles = triangleRepository.query(specification);
        List<Triangle> expectedTriangles = new ArrayList<>();
        expectedTriangles.add(triangle);
        Assert.assertEquals(actualTriangles,expectedTriangles);

    }



    @AfterClass
    public void tierDown(){
        triangleRepository = null;
        triangle = null;
        triangleTwo =  null;
        specification = null;
    }


}


