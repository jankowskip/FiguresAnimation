package model;

import gui.PaintFigures;

import java.util.List;

import javax.swing.JTextField;

import model.figures.Figure;
import model.intersect.IntersectCircleWithRectangle;
import model.intersect.IntersectCircles;
import model.intersect.IntersectRectangles;
import model.intersect.IntersectStrategyService;

public class FiguresUpdate implements Runnable {
	private PaintFigures canvas;
	private double fps;
	private double delta = 1.0 / fps;
	private boolean runFlag = true;
	private FiguresList figuresList;
	private JTextField number;
	private boolean paused = false;
	private IntersectStrategyService service;

	public FiguresUpdate(FiguresList figuresList, PaintFigures canvas, JTextField number, double fps) {
		this.fps = fps;
		delta = 1.0 / fps;
		this.figuresList = figuresList;
		this.canvas = canvas;
		this.number = number;
		IntersectStrategyService service = new model.intersect.IntersectStrategyService();
		service.addStrategy(FigureType.Circle, FigureType.Circle, new IntersectCircles());
		service.addStrategy(FigureType.Circle, FigureType.Rectangle, new IntersectCircleWithRectangle());
		service.addStrategy(FigureType.Rectangle, FigureType.Rectangle, new IntersectRectangles());
		this.service = service;

	}

	public void run() {
		double nextTime = (double) System.nanoTime() / 1000000000.0;
		double maxTimeDiff = 0.5;
		int skippedFrames = 1;
		int maxSkippedFrames = 5;
		while (runFlag) {
			if (paused) {
				nextTime += delta;
			}
			double currTime = (double) System.nanoTime() / 1000000000.0;
			if ((currTime - nextTime) > maxTimeDiff)
				nextTime = currTime;
			if (currTime >= nextTime && !paused) {
				nextTime += delta;
				update();
				if ((currTime < nextTime) || (skippedFrames > maxSkippedFrames)) {
					canvas.repaint();
					skippedFrames = 1;
				} else {
					skippedFrames++;
				}
			} else {
				int sleepTime = (int) (1000.0 * (nextTime - currTime));
				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {

					}
				}
			}
		}

	}

	public void pauseResume() {
		if (paused) {
			paused = false;
		} else {
			paused = true;
		}
	}

	public void update() {
		List<Figure> list = figuresList.getList();
		number.setText(figuresList.countFigures());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move();
		}
		for (int i = 0; i < list.size(); i++) {
			Figure figure = list.get(i);
			FigureMathHelper.wallXBounceDetect(figure, canvas);
			FigureMathHelper.wallYBounceDetect(figure, canvas);
			for (int j = i + 1; j < list.size(); j++) {
				Figure other = list.get(j);

				if (service.intersect(figure, other)) {

					FigureMathHelper.figureBounceDetected(figure, other);
				}
			}
		}
	}

	

}