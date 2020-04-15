package by.prokhorenko.shapes;

import by.prokhorenko.shapes.exception.ServiceException;
import by.prokhorenko.shapes.factory.ServiceFactory;
import by.prokhorenko.shapes.repository.Impl.TriangleRepositoryImpl;
import by.prokhorenko.shapes.repository.Repository;
import by.prokhorenko.shapes.service.ITriangleService;

public class Main {
    public static void main(String[] args) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ITriangleService triangleService = serviceFactory.getTriangleService();
        triangleService.getAllTriangles("src//by//prokhorenko//shapes//resources//data.txt");
        Repository triangleRepository = TriangleRepositoryImpl.getTriangleRepository();
        System.out.println(triangleRepository);
    }
}
