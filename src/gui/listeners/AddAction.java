package gui.listeners;

import gui.AddFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.FiguresFactory;
import model.FiguresList;

public class AddAction implements ActionListener {
	private FiguresList figuresList;
	private FiguresFactory figuresFactory;
	private JFrame guiFrame;

	public AddAction(FiguresList figuresList, FiguresFactory figuresFactory, JFrame guiFrame) {
		this.figuresList = figuresList;
		this.figuresFactory = figuresFactory;
		this.guiFrame = guiFrame;

	}

	public void actionPerformed(ActionEvent e) {
		new AddFrame(figuresList, figuresFactory, guiFrame);

	}

}
