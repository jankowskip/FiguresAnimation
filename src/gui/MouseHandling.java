package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Set;

import model.FiguresList;
import model.figures.Figure;

public class MouseHandling extends MouseAdapter {
	private FiguresList figuresList;
	private List<Figure> list;
	private Set<Integer> set;

	public MouseHandling(FiguresList figuresList) {
		this.figuresList = figuresList;
		list = figuresList.getList();
		set = figuresList.getSet();
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		for (int i = 0; i < list.size(); i++) {
			Figure f = list.get(i);
			if (f.contains(me.getPoint())) {
				if (!set.contains(i)) {
					figuresList.addKey(i);
				} else {
					figuresList.removeKey(i);
				}
			}
		}

	}

}
