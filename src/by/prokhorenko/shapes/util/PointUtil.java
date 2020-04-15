package by.prokhorenko.shapes.util;

import by.prokhorenko.shapes.entity.Point;


public class PointUtil {

        public static double countDistance(Point pointOne, Point pointTwo){
            double pointOneX = pointOne.getX();
            double pointOneY = pointOne.getY();
            double pointTwoX = pointTwo.getX();
            double pointTwoY = pointTwo.getY();

            double distance = Math.sqrt(Math.pow(pointTwoX - pointOneX, 2) + Math.pow(pointTwoY - pointOneY, 2));

            return distance;

        }


    }
