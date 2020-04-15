package by.prokhorenko.shapes.entity;

import by.prokhorenko.shapes.observer.impl.TriangleObserver;
import by.prokhorenko.shapes.util.IdGenerator;
import by.prokhorenko.shapes.observer.Observable;
import by.prokhorenko.shapes.observer.Observer;


public class Triangle implements Observable {

    private long id;
    private Point firstTop;
    private Point secondTop;
    private Point thirdTop;
    private Observer observer;

    {
        observer = new TriangleObserver();
    }

    public Triangle(Point firstTop, Point secondTop, Point thirdTop){
        this.id = IdGenerator.getId();
        this.firstTop = firstTop;
        this.secondTop = secondTop;
        this.thirdTop = thirdTop;
        notifyObservers();
    }

    public Triangle(long id,Point firstTop, Point secondTop, Point thirdTop){
        this.id = id;
        this.firstTop = firstTop;
        this.secondTop = secondTop;
        this.thirdTop = thirdTop;
        notifyObservers();
    }



    public Triangle(){
        this.id = 0L;
        this.firstTop = new Point(0,0);
        this.secondTop = new Point(1,1);
        this.thirdTop = new Point(2,0);
        notifyObservers();
    }


    public Point getFirstTop() {
        return firstTop;
    }

    public void setFirstTop(Point firstTop) {
        this.firstTop = firstTop;
        notifyObservers();
    }

    public Point getSecondTop() {
        return secondTop;
    }

    public void setSecondTop(Point secondTop) {
        this.secondTop = secondTop;
        notifyObservers();
    }

    public Point getThirdTop() {
        return thirdTop;
    }

    public void setThirdTop(Point thirdTop) {
        this.thirdTop = thirdTop;
        notifyObservers();
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Triangle other = (Triangle) o;
        if(id != other.id) return false;
        if(firstTop == null){
            if(other.firstTop != null) return false;
        }else if(!firstTop.equals(other.firstTop)) return false;
        if(secondTop == null){
            if(other.secondTop != null) return false;
        }else if(!secondTop.equals(other.secondTop)) return false;
        if(thirdTop == null){
            if(other.thirdTop != null) return false;
        }else if(!thirdTop.equals(other.thirdTop)) return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result =  PRIME * result + (int) (id ^ (id >>> 32));
        result = PRIME * result + (firstTop == null ? 0 : firstTop.hashCode());
        result = PRIME * result + (secondTop == null ? 0 : secondTop.hashCode());
        result = PRIME * result + (thirdTop == null ? 0 : thirdTop.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("id=").append(id);
        sb.append(", firstTop=").append(firstTop);
        sb.append(", secondTop=").append(secondTop);
        sb.append(", thirdTop=").append(thirdTop);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public void attach(Observer observer) {

        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if(observer != null){
            observer.update(this);
        }
    }
}
