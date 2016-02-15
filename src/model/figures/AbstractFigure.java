package model.figures;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import model.Point;

public abstract class AbstractFigure implements Figure {
	private static final double DEFAULT_VELOCITY = 4;
	private Shape shape;
	private Point point;
	private double velocityX;
	private double velocityY;
	private double width;
	private double height;
	private double mass;
	private boolean mark;

	AbstractFigure(Shape shape, double width, double x, double y) {
		this(shape, width, width, x, y);
	}

	public AbstractFigure(Shape shape, double width, double height, double x, double y) {
		point = new Point(x, y);
		this.shape = shape;
		this.width = width;
		this.height = height;
		mass = (height + width) / 2;
		Random r = new Random();
		velocityX = randomVelocity(r);
		velocityY = randomVelocity(r);
		setXY(point.getX(), point.getY());

	}

	public boolean contains(Point2D point) {
		return shape.contains(point);
	}

	public Rectangle2D getBounds() {
		return shape.getBounds2D();
	}

	public Shape getShape() {
		return shape;
	}

	public Point getPoint() {
		return point;
	}

	public boolean isMarked() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	private double randomVelocity(Random r) {
		if (r.nextInt(2) > 0) {
			return -DEFAULT_VELOCITY;
		}
		return DEFAULT_VELOCITY;
	}

	public void move() {
		double x = point.getX() + getVelocityX();
		double y = point.getY() + getVelocityY();
		setXY(x, y);
	}

	public void setXY(Shape shape, double x, double y) {
		point.setX(x);
		point.setY(y);
		this.shape = shape;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

}
