package by.prokhorenko.shapes.reader;

import by.prokhorenko.shapes.entity.Triangle;
import by.prokhorenko.shapes.exception.ReaderException;

import java.util.List;

public interface ITriangleReader {
    List<Triangle> readTriangles(String path) throws ReaderException;
}
