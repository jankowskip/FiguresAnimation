package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FigureType;

public class AddErrorHandle implements ActionListener {

	private static final Pattern VALID_WORD = Pattern.compile("^[A-Za-z]*$");
	private final String TEXT_ERROR = "Use numbers from 10 to 99 to determine the height and width";
	private final String SELECTION_ERROR = "Select a figure from the list";
	private JFrame frame;


	public boolean checkTextField(String check) {
		return checkCharacters(check) && checkLenght(check);
	}

	public boolean checkCharacters(String check) {
		if (!VALID_WORD.matcher(check).matches()) {
			return true;
		} else {
			ErrorFrame(TEXT_ERROR);
			return false;
		}
	}

	public boolean checkLenght(String check) {
		if (2 == check.length()) {
			return true;
		} else {
			ErrorFrame(TEXT_ERROR);
			return false;
		}
	}

	public boolean checkSelection(FigureType selection) {

		if (selection != null) {
			return true;
		} else {
			ErrorFrame(SELECTION_ERROR);
			return false;
		}

	}

	public void ErrorFrame(String statement) {
		frame = new JFrame("Error");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(statement);
		JButton button = new JButton("Alright, i'm sorry");
		button.addActionListener(this);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setBackground(Color.WHITE);
		panel.add(label);
		panel.add(button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 100);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();

	}

}
