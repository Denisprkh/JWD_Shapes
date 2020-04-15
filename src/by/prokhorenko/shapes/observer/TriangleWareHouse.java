package by.prokhorenko.shapes.observer;

import by.prokhorenko.shapes.entity.TriangleParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleWareHouse {

    private final static Logger log = LogManager.getLogger();
    private Map<Long, TriangleParameters> triangleOptions = new HashMap<>();

    private TriangleWareHouse(){}

    private final static TriangleWareHouse INSTANCE = new TriangleWareHouse();

    public static TriangleWareHouse getInstance(){
        return INSTANCE;
    }

    public void saveTriangleParameters(long id, TriangleParameters triangleParameters){
          triangleOptions.put(id,triangleParameters);
          log.info("Triangle with id: " + id + " was updated with such parameters: " + triangleParameters);
    }

    public TriangleParameters getTriangleParameters(long id){
        return triangleOptions.get(id);
    }
}
