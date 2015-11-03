package utils;

import entity.Point;

public class ServiceUtils {

	public static int getWeight(Point p1, Point p2){
		double x = Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow((p2.getY()-p1.getY()), 2));
		return (int) x;
	}
	
}
