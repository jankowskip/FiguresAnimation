package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import model.figures.Figure;

public class FiguresList {
	private volatile List<Figure> figuresList;
	private Set<Integer> set;

	public FiguresList() {
		figuresList = new ArrayList<Figure>();
		set = new TreeSet<Integer>(Collections.reverseOrder());

	}

	public List<Figure> getList() {
		return figuresList;
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void addFigure(Figure f) {
		figuresList.add(f);

	}

	public void deleteFigure() {
		for (Integer i : set) {
			figuresList.remove(i.intValue());

		}
		set.clear();
	}

	public String countFigures() {
		String count = Integer.toString(figuresList.size());
		return count;
	}

	public void addKey(int i) {
		set.add(i);
	}

	public void removeKey(int i) {
		Integer j = (Integer) i;
		set.remove(j);
	}

}
