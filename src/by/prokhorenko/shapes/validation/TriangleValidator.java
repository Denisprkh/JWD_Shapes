package by.prokhorenko.shapes.validation;

import by.prokhorenko.shapes.entity.Point;


public class TriangleValidator {

    private static final String REGEX = "^([-]?(\\d)+([\\\\.]?(\\d)+)?(\\s)+){5}([-]?(\\d)+([\\\\.]?(\\d)+)?(\\s)*)$";

    public boolean dataStringIsCorrect(String data){
        return data.matches(REGEX);
    }

    public boolean pointsAreOnLine(Point one, Point two, Point three){
        return Double.compare((three.getX() - one.getX()) / (two.getX() - one.getX()),
                (three.getY() - one.getY()) / (two.getY() - one.getY())) == 0;
    }

}
