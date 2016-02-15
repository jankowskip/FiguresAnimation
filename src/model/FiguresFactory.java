package model;

import java.util.List;
import java.util.Random;

import model.figures.Circle;
import model.figures.Figure;
import model.figures.Rectangle;
import model.figures.Square;

public class FiguresFactory {
	private int width;
	private int height;

	private List<FigureType> listOfTypes = FigureType.valuesAsList();
	
	public FiguresFactory(int width, int height) {

	}


	public Figure createFigure(FigureType figureType, int widthFigure, int heightFigure, int widthX, int heightY) {
		switch (figureType) {
		case Rectangle:
			return new Rectangle(widthFigure, heightFigure, randomX(widthX), randomY(heightY));
		case Circle:
			return new Circle(widthFigure, randomX(widthX), randomY(heightY));
		case Square:
			return new Square(widthFigure, randomX(widthX), randomY(heightY));
		}
		throw new IllegalArgumentException("the figure type " + figureType + "is not recognized");
	}

//	public void setWidth(int width) {
//		this.width = width;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}

	public int randomX(int widthX) {
		return randomLocation(widthX);
	}

	public int randomY(int heightY) {
		return randomLocation(heightY);

	}

	public List<FigureType> getTypeList() {
		return listOfTypes;
	}

	public int randomLocation(int min) {
		Random r = new Random();
		int max = min + 100;
		return r.nextInt(max - min + 1) + min;

	}

}
