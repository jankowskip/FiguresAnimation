package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

import model.FiguresList;
import model.figures.Figure;

public class PaintFigures extends JPanel {
	private List<Figure> list;
	private Set<Integer> set;
	private Color[] colors = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.ORANGE };

	public PaintFigures(FiguresList figuresList) {
		list = figuresList.getList();
		set = figuresList.getSet();
		addMouseListener(new MouseHandling(figuresList));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawFigure(g2d);

	}

	public void drawFigure(Graphics2D g2d) {
		for (int i = 0; i < list.size(); i++) {
			g2d.setColor(color(i));
			Figure f = list.get(i);
			if (set.contains(i)) {
				g2d.setColor(Color.WHITE);
			}
			g2d.draw(f.getShape());
			g2d.fill(f.getShape());
		}

	}

	public Color color(int index) {
		if (colors.length <= index) {
			return Color.BLACK;
		}
		return colors[index];
	}

}
