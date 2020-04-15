package by.prokhorenko.shapes.factory;

import by.prokhorenko.shapes.service.ITriangleService;
import by.prokhorenko.shapes.service.impl.TriangleServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory(){

    }

    private ITriangleService triangleService = new TriangleServiceImpl();

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }
    public ITriangleService getTriangleService(){
        return triangleService;
    }

}
