package model.intersect;

import model.figures.Circle;
import model.figures.Figure;

public class IntersectCircles implements IntersectStrategy {

	@Override
	public boolean intersect(Figure f1, Figure f2) {
		Circle circle = (Circle) f1;
		Circle circle2 = (Circle) f2;
		double length = Math.hypot(circle2.getPoint().getX() - circle.getPoint().getX(), circle2.getPoint().getY() - circle.getPoint().getY());
		return length <= (circle2.getWidth() + circle.getWidth()) / 2;
	}

}
