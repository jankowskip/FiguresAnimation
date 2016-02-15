package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.FiguresUpdate;

public class StartStopAction implements ActionListener {

	private static final String START = "Start";
	private static final String STOP = "Stop";
	private JButton button;
	private FiguresUpdate figuresUpdate;

	public StartStopAction(FiguresUpdate figuresUpdate, JButton button) {
		this.button = button;
		this.figuresUpdate = figuresUpdate;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (button.getText().equals(STOP)) {
			button.setText(START);

		} else {
			button.setText(STOP);

		}
		figuresUpdate.pauseResume();

	}

}
