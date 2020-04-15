package by.prokhorenko.shapes.reader.util;

import by.prokhorenko.shapes.exception.UtilException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    private final static Logger log = LogManager.getLogger();
    public static List <String> readStringsFromFile(String link) throws UtilException {
        List <String >lines;
        try{
            Path path = Paths.get(link);
            Stream<String> stream = Files.lines(path);
           lines = stream.collect(Collectors.toList());
        } catch (IOException e ) {
            log.error("File reading error");
            throw new UtilException("File reading error");
        }
        log.info("Lines were read");
        return lines;
    }
}
