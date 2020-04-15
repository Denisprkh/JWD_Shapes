package by.prokhorenko.shapes.entity;

public class Point {

    private double x;
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point other = (Point) o;
        if (x != other.x) return false;
        if (y != other.y) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        long longBitsX = Double.doubleToLongBits(x);
        long longBitsY = Double.doubleToLongBits(y);
        result = result * PRIME + (int) (longBitsX ^ (longBitsX >>> 32));
        result = result * PRIME + (int) (longBitsY ^ (longBitsY >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}


