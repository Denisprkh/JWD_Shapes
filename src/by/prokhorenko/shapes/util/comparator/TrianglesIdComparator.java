package by.prokhorenko.shapes.util.comparator;

import by.prokhorenko.shapes.entity.Triangle;

import java.util.Comparator;

public class TrianglesIdComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getId() - o2.getId());
    }
}
