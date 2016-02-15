package model.figures;

import model.FigureType;

public class Circle extends EllipseType {

	public Circle(double width, double x, double y) {
		super(width, x, y);
	}

	@Override
	public FigureType getType() {
		return FigureType.Circle;
	}

}
