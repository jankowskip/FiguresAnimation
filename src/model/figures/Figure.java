package model.figures;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import model.FigureType;
import model.Point;

public interface Figure {

	FigureType getType();

	Point getPoint();

	Shape getShape();

	double getMass();

	Rectangle2D getBounds();

	double getHeight();

	double getWidth();

	double getVelocityX();

	void setVelocityX(double velocityX);

	double getVelocityY();

	void setVelocityY(double velocityY);

	void move();

	void setXY(double x, double y);

	boolean contains(Point2D point);

}
