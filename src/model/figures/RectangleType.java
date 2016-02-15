package model.figures;

import java.awt.geom.Rectangle2D;

import model.FigureType;

public abstract class RectangleType extends AbstractFigure {

	RectangleType(double width, double x, double y) {
		this(width, width, x, y);
	}

	RectangleType(double width, double height, double x, double y) {
		super(new Rectangle2D.Double(x, y, width, width), width, height, x, y);
	}

	public void setXY(double x, double y) {
		super.setXY(new Rectangle2D.Double(x, y, getWidth(), getHeight()), x, y);
	}

	public FigureType getType() {
		return FigureType.Rectangle;
	}

}
