package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum FigureType {

	Rectangle(false), Circle(true), Square(true);
	private boolean symmetrical;

	private FigureType(boolean symmetrical) {
		this.symmetrical = symmetrical;

	}

	public boolean isSymmetrical() {
		return symmetrical;
	}

	public static List<FigureType> valuesAsList() {
		return new ArrayList<FigureType>(Arrays.asList(FigureType.values()));
	}
}
