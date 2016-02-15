package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JLabel;

import model.FiguresList;

public class DeleteAction implements ActionListener {
	private JLabel label;
	private FiguresList figuresList;
	private Set<Integer> set;

	public DeleteAction(JLabel label, FiguresList figuresList) {
		this.label = label;
		this.figuresList = figuresList;
		this.set = figuresList.getSet();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (set.isEmpty()) {
			label.setText("Click on the figure you want to delete");
		} else {
			figuresList.deleteFigure();
			label.setText("");

		}

	}

}
