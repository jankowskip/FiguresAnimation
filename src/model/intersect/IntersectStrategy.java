package model.intersect;

import model.figures.Figure;

public interface IntersectStrategy {
	public boolean intersect(Figure f1, Figure f2);
}
