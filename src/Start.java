import gui.GUI;

public class Start {

	public static void main(String[] args) {

		int width = 1000;
		int height = 800;
		double fps = 60;

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI(width, height, fps);
			}
		});

	}
}