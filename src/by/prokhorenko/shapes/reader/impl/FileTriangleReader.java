package by.prokhorenko.shapes.reader.impl;

import by.prokhorenko.shapes.exception.ReaderException;
import by.prokhorenko.shapes.exception.UtilException;
import by.prokhorenko.shapes.reader.util.FileUtil;
import by.prokhorenko.shapes.reader.ITriangleReader;
import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.util.parser.Parser;
import by.prokhorenko.shapes.validation.ReaderValidator;
import by.prokhorenko.shapes.validation.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;



public class FileTriangleReader implements ITriangleReader {
    private final static Logger log = LogManager.getLogger();
    private ReaderValidator readerValidator = new ReaderValidator();
    private TriangleValidator triangleValidator = new TriangleValidator();
    private Parser parser = new Parser();
    private final String defaultPath = "src//by//prokhorenko//shapes//resources//defaultPath.txt";

    @Override
    public List<Triangle> readTriangles(String path) throws ReaderException {
        String correctPath;
        if(readerValidator.fileIsExists(path) && !readerValidator.isEmptyFile(path)){
            log.info("Came path is correct");
            correctPath = path;
        }else{
            log.info("The path was changed on a default path");
            correctPath = defaultPath;
        }

        List<String> correctData = getCorrectDataStrings(correctPath);

        List<Triangle> triangles = new ArrayList<>();

        for(String triangleData : correctData){
            try {
                Triangle triangle = parser.parseTriangleFromString(triangleData);
                triangles.add(triangle);
            } catch (UtilException e) {
                log.error("Parsing triangle failed. Data for parsing: " + triangleData);
                throw new ReaderException("Parsing triangle error");

            }
        }
        return triangles;
    }

    private List<String> getCorrectDataStrings(String path) throws ReaderException {

        List<String> correctData;
        List <String> dataForTriangles = null;
        try {
           dataForTriangles = FileUtil.readStringsFromFile(path);

        } catch (UtilException e) {
            log.error("Reading data for triangles error");
            throw new ReaderException("Can't read data for triangles", e);
        }
        correctData = new ArrayList<>();
        for(String data : dataForTriangles){
            if(triangleValidator.dataStringIsCorrect(data) ){
                correctData.add(data);
            }
        }
        log.info("Correct lines for parsing were selected" + correctData);
        return correctData;
    }


}
