package model.intersect;

import model.figures.Circle;
import model.figures.Figure;
import model.figures.RectangleType;

public class IntersectCircleWithRectangle implements IntersectStrategy {

	public boolean intersect(Figure f1, Figure f2) {
		Circle circle;
		RectangleType rectangle;
		if (f1 instanceof Circle) {
			circle = (Circle) f1;
			rectangle = (RectangleType) f2;
		} else {
			circle = (Circle) f2;
			rectangle = (RectangleType) f1;
		}

		double distanceBetweenX = Math.abs(circle.getBounds().getCenterX() - rectangle.getBounds().getCenterX());
		double distanceBetweenY = Math.abs(circle.getBounds().getCenterY() - rectangle.getBounds().getCenterY());

		if (distanceBetweenX > (rectangle.getWidth() / 2 + circle.getWidth() / 2)) {
			return false;
		}
		if (distanceBetweenY > (rectangle.getHeight() / 2 + circle.getWidth() / 2)) {
			return false;
		}

		if (distanceBetweenX <= (rectangle.getWidth() / 2)) {
			return true;
		}
		if (distanceBetweenY <= (rectangle.getHeight() / 2)) {
			return true;
		}

		double cornerDistance = Math.pow(distanceBetweenX - rectangle.getWidth() / 2, 2) + Math.pow(distanceBetweenY - rectangle.getHeight() / 2, 2);

		return (cornerDistance <= (Math.pow(circle.getWidth() / 2, 2)));
	}

}
