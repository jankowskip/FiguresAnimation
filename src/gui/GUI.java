package gui;

import gui.listeners.AddAction;
import gui.listeners.DeleteAction;
import gui.listeners.StartStopAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.FiguresFactory;
import model.FiguresList;
import model.FiguresUpdate;

public class GUI extends JFrame {
	private JButton stopButton;
	private JButton addFigure;
	private JButton deleteFigure;
	private JTextField number;
	private JLabel numberOfFigures;
	private JLabel deleteInformation;
	private PaintFigures canvas;
	private JPanel componentsPanel;
	private FiguresList figuresList;
	private FiguresFactory figuresFactory;
	private FiguresUpdate figuresUpdate;

	public GUI(int width, int height, double fps) {
		super("Figures Animation");
		number = new JTextField(2);
		number.setEditable(false);
		figuresFactory = new FiguresFactory(width, height);
		figuresList = new FiguresList();
		canvas = new PaintFigures(figuresList);
		canvas.setBackground(Color.GRAY);
		stopButton = new JButton("Stop");
		addFigure = new JButton("Add Figure");
		deleteFigure = new JButton("Delete Figure");
		deleteInformation = new JLabel("");
		numberOfFigures = new JLabel("Number of figures: ");
		figuresUpdate = new FiguresUpdate(figuresList, canvas, number, fps);
		componentsPanel = new JPanel();
		componentsPanel.setLayout(new GridBagLayout());
		componentsPanel.add(numberOfFigures);
		componentsPanel.add(number);
		componentsPanel.add(addFigure);
		componentsPanel.add(deleteFigure);
		componentsPanel.add(stopButton);
		componentsPanel.add(deleteInformation);
		deleteFigure.addActionListener(new DeleteAction(deleteInformation, figuresList));
		addFigure.addActionListener(new AddAction(figuresList, figuresFactory, this));
		stopButton.addActionListener(new StartStopAction(figuresUpdate, stopButton));

		getContentPane().add(BorderLayout.CENTER, canvas);
		getContentPane().add(BorderLayout.SOUTH, componentsPanel);

		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		Thread thread = new Thread(figuresUpdate);
		thread.start();

	}

}
