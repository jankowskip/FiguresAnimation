package model.figures;

import java.awt.geom.Ellipse2D;

public abstract class EllipseType extends AbstractFigure {

	EllipseType(double width, double x, double y) {
		this(width, width, x, y);
	}

	EllipseType(double width, double height, double x, double y) {
		super(new Ellipse2D.Double(x, y, width, width), width, height, x, y);
	}

	public void setXY(double x, double y) {
		super.setXY(new Ellipse2D.Double(x, y, getWidth(), getHeight()), x, y);
	}

}
