package model.intersect;

import model.figures.Figure;
import model.figures.RectangleType;

public class IntersectRectangles implements IntersectStrategy {

	@Override
	public boolean intersect(Figure f1, Figure f2) {
		RectangleType rectangle = (RectangleType) f1;
		RectangleType rectangle2 = (RectangleType) f2;
		return rectangle2.getBounds().intersects(rectangle.getBounds());

	}

}
