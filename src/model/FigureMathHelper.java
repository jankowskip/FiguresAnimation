package model;

import javax.swing.JPanel;

import model.figures.Figure;

public class FigureMathHelper {
	private FigureMathHelper() {

	}

	public static void figureBounceDetected(Figure f1, Figure f2) {
		double newSpeedF1X = calculateVelocityX(f1, f2);
		double newSpeedF1Y = calculateVelocityY(f1, f2);

		double newSpeedF2X = calculateVelocityX(f2, f1);
		double newSpeedF2Y = calculateVelocityY(f2, f1);

		f1.setXY(f1.getPoint().getX() + newSpeedF1X, f1.getPoint().getY() + newSpeedF1Y);
		f2.setXY(f2.getPoint().getX() + newSpeedF2X, f2.getPoint().getY() + newSpeedF2Y);

		f1.setVelocityX(newSpeedF1X);
		f1.setVelocityY(newSpeedF1Y);
		f2.setVelocityX(newSpeedF2X);
		f2.setVelocityY(newSpeedF2Y);
	}
	
	public static void wallXBounceDetect(Figure f, JPanel canvas) {
		f.setVelocityX(wallBounceDetect(f.getPoint().getX(), f.getWidth(), canvas.getWidth(), f.getVelocityX()));
	}

	public static void wallYBounceDetect(Figure f, JPanel canvas) {
		f.setVelocityY(wallBounceDetect(f.getPoint().getY(), f.getHeight(), canvas.getHeight(), f.getVelocityY()));
	}

	private static double calculateVelocityX(Figure a, Figure b) {
		return calculateVelocity(a.getVelocityX(), a.getMass(), b.getVelocityX(), b.getMass());
	}

	private static double calculateVelocityY(Figure a, Figure b) {
		return calculateVelocity(a.getVelocityY(), a.getMass(), b.getVelocityY(), b.getMass());
	}

	private static double calculateVelocity(double velocity, double mass, double velocity2, double mass2) {
		return (velocity * (mass - mass2) + (2 * mass2 * velocity2)) / (mass + mass2);
	}
	
	private static double wallBounceDetect(double location, double size, double maxValue, double velocity) {
		if ((location < 0 && velocity < 0) || (location + size > maxValue && velocity > 0)) {
			return -velocity;
		}
		return velocity;
	}

}
