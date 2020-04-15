package by.prokhorenko.shapes.service.impl;

import by.prokhorenko.shapes.exception.ReaderException;
import by.prokhorenko.shapes.factory.EntityFactory;
import by.prokhorenko.shapes.repository.Repository;
import by.prokhorenko.shapes.util.PointUtil;
import by.prokhorenko.shapes.entity.Point;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.service.ITriangleService;
import by.prokhorenko.shapes.exception.ServiceException;
import by.prokhorenko.shapes.reader.ITriangleReader;
import by.prokhorenko.shapes.reader.impl.FileTriangleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleServiceImpl implements ITriangleService {



    private final static Logger log = LogManager.getLogger();
    private ITriangleReader triangleReader = new FileTriangleReader();
    private EntityFactory entityFactory = EntityFactory.getInstance();
    private final double DELTA = 0.001;
    private final int FIRST_SIDE = 0;
    private final int SECOND_SIDE = 1;
    private final int THIRD_SIDE = 2;


    @Override
    public List<Triangle> getAllTriangles(String path) throws ServiceException {


        List <Triangle> triangles = null;
        try {
            triangles = triangleReader.readTriangles(path);

        } catch (ReaderException e) {
            log.error("Getting all triangles error from file:" + path);
            throw new ServiceException("Getting all triangles error",e);
        }

        return triangles;
    }

    @Override
    public Triangle getTriangle(long id, String path) throws ServiceException {
        List <Triangle> triangles = getAllTriangles(path);

        Triangle triangleResult = null;
        for(Triangle triangle : triangles){
            if(triangle.getId() == id){
                triangleResult = triangle;
            }
        }

        return triangleResult;
    }

    @Override
    public double countPerimeter(Triangle triangle){

        double[] sides = countTrianglesSides(triangle);
        double perimeter = 0.0;
        for(double side : sides){
            perimeter += side;
        }

        log.info("Perimeter of " + triangle + " is "+ perimeter);
        return perimeter;
    }

    @Override
    public double countArea(Triangle triangle){

        double semiPerimeter = countPerimeter(triangle) / 2;
        double[] sides = countTrianglesSides(triangle);
        double area = Math.sqrt(semiPerimeter*(semiPerimeter - sides[FIRST_SIDE]) * (semiPerimeter - sides[SECOND_SIDE]) *
                (semiPerimeter - sides[THIRD_SIDE]));
        log.info("Area of " + triangle + " is "+ area);
        return area;
    }

    @Override
    public boolean isRectangular(Triangle triangle){
        double [] sides = countTrianglesSides(triangle);
        double sqrOfFirstSide = Math.pow(sides[FIRST_SIDE],2);
        double sqrOfSecondSide = Math.pow(sides[SECOND_SIDE],2);
        double sqrOfThirdSide = Math.pow(sides[THIRD_SIDE],2);
        return Math.abs((sqrOfFirstSide + sqrOfThirdSide) - sqrOfSecondSide) < DELTA ||
                Math.abs((sqrOfFirstSide + sqrOfSecondSide) - sqrOfThirdSide) < DELTA ||
                Math.abs((sqrOfSecondSide + sqrOfThirdSide) - sqrOfFirstSide) < DELTA;

    }

    @Override
    public boolean isIsosceles(Triangle triangle){
        double[] sides = countTrianglesSides(triangle);
        return Math.abs(sides[FIRST_SIDE] - sides[SECOND_SIDE]) < DELTA || Math.abs(sides[FIRST_SIDE] - sides[THIRD_SIDE]) < DELTA ||
                Math.abs(sides[SECOND_SIDE] - sides[THIRD_SIDE]) < DELTA;

    }

    @Override
    public boolean isEquilateral(Triangle triangle){

        double[] sides = countTrianglesSides(triangle);
        return Math.abs(sides[FIRST_SIDE] - sides[SECOND_SIDE]) < DELTA && Math.abs(sides[FIRST_SIDE] - sides[THIRD_SIDE]) < DELTA;
    }

    @Override
    public boolean isAcuteAngled(Triangle triangle){
        double[] sides = countTrianglesSides(triangle);
        int indexOfLongestSide = getIndexOfLongestSide(triangle);
        double longestSide = sides[indexOfLongestSide];
        double sumOfSqrOfAnotherSides = countSumOfSqrOfSmallerSides(triangle);
        return Double.compare((Math.pow(longestSide,2)) , sumOfSqrOfAnotherSides) == -1;

    }

    private double countSumOfSqrOfSmallerSides(Triangle triangle){
        double[] sides = countTrianglesSides(triangle);
        int indexOfLongestSide = getIndexOfLongestSide(triangle);
        double sumOfSqrOfAnotherSides = 0;
        for(int i = 0; i < sides.length; i++){
            if(i != indexOfLongestSide){
                sumOfSqrOfAnotherSides = sumOfSqrOfAnotherSides + Math.pow(sides[i],2);
            }
        }

        return sumOfSqrOfAnotherSides;
    }
    @Override
    public boolean isObtuse(Triangle triangle){

        double[] sides = countTrianglesSides(triangle);
        int indexOfLongestSide = getIndexOfLongestSide(triangle);
        double longestSide = sides[indexOfLongestSide];
        double sumOfSqrOfAnotherSides = countSumOfSqrOfSmallerSides(triangle);
        return Double.compare(Math.pow(longestSide,2) , sumOfSqrOfAnotherSides) == 1;


    }

    private double[] countTrianglesSides(Triangle triangle){

        Point topOne = triangle.getFirstTop();
        Point topTwo = triangle.getSecondTop();
        Point topThree = triangle.getThirdTop();

        double result[] = new double[3];
        double thirdSide;
        double firstSide;
        double secondSide;

            thirdSide = PointUtil.countDistance(topThree, topOne);
            firstSide = PointUtil.countDistance(topOne,topTwo);
            secondSide = PointUtil.countDistance(topTwo,topThree);

        result[0] = firstSide;
        result[1] = secondSide;
        result[2] = thirdSide;
        return result;

    }

    private int getIndexOfLongestSide(Triangle triangle)  {
        double sides[] = countTrianglesSides(triangle);
        int indexOfLongestSide = 0;
        for(int i = 0; i < sides.length; i++){
            if(sides[indexOfLongestSide] < sides[i]){
                indexOfLongestSide = i;
            }
        }

        return indexOfLongestSide;
    }

    public Point findNearestPointToCoordinatesBeginning(Triangle triangle){

        Point beginningOfCoordinates = entityFactory.getPoint(0,0);
        List<Point> tops = new ArrayList<>();
        tops.add(triangle.getFirstTop());
        tops.add(triangle.getSecondTop());
        tops.add(triangle.getThirdTop());

        double distances[] = new double[3];

            distances[0] = PointUtil.countDistance(beginningOfCoordinates,tops.get(0));
            distances[1] = PointUtil.countDistance(beginningOfCoordinates,tops.get(1));
            distances[2] = PointUtil.countDistance(beginningOfCoordinates,tops.get(2));


        double shortestDistance = distances[0];
        int indexOfNearestPoint = -1;
        for(int i = 0; i < distances.length; i++){
            if(shortestDistance > distances[i]){
                indexOfNearestPoint = i;
            }
        }

        return tops.get(indexOfNearestPoint);
    }

}
