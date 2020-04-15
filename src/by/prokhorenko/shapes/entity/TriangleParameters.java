package by.prokhorenko.shapes.entity;

public class TriangleParameters {

    private double area;
    private double perimeter;

    public TriangleParameters(double area, double perimeter){
        this.area = area;
        this.perimeter = perimeter;
    }

    public TriangleParameters(){

    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleParameters that = (TriangleParameters) o;
        if (Double.compare(that.area, area) != 0) return false;
        if(Double.compare(that.perimeter, perimeter) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleParameters{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
