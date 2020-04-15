package by.prokhorenko.shapes.repository.Impl;

import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.RepositoryException;
import by.prokhorenko.shapes.repository.Repository;
import by.prokhorenko.shapes.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryImpl implements Repository<Triangle> {

    private List<Triangle> triangles;
    private final static Logger log = LogManager.getLogger();

    private TriangleRepositoryImpl(){
        triangles = new ArrayList<>();
    }

    private static final TriangleRepositoryImpl INSTANCE = new TriangleRepositoryImpl();

    public static TriangleRepositoryImpl getTriangleRepository(){
        return INSTANCE;
    }


    @Override
    public boolean delete(Triangle triangle) throws RepositoryException {
        if(triangle == null){
            log.error("Deleting triangle error: its null");
            throw new RepositoryException("Deleting triangle error");
        }
        return triangles.remove(triangle);
    }

    @Override
    public boolean save(Triangle triangle) throws RepositoryException {
         if(triangle == null){
            log.error("Adding triangle error: its null");
            throw new RepositoryException("Adding triangle error");
        }
        return triangles.add(triangle);
    }

    @Override
    public boolean update(Triangle triangle) throws RepositoryException {

        Triangle triangleExists = null;
        for(Triangle anotherTriangle : triangles){
            if(triangle.getId() == anotherTriangle.getId()){
                triangleExists = anotherTriangle;
                break;
            }
        }

        return delete(triangleExists) && save(triangle);
    }

    public List<Triangle> query(Specification specification) {
        List<Triangle> list = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (specification.specify(triangle)) {
                list.add(triangle);
            }
        }
        return list;
    }

    @Override
    public Triangle get(int index) {
        return triangles.get(index);
    }

    @Override
    public int size() {
        return triangles.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleRepositoryImpl{");
        sb.append("triangles=").append(triangles);
        sb.append('}');
        return sb.toString();
    }
}
