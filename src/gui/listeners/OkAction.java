package gui.listeners;

import static java.lang.Integer.parseInt;
import gui.AddErrorHandle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.FiguresFactory;
import model.FiguresList;
import model.figures.Figure;

public class OkAction implements ActionListener {

	private JFrame addFrame;
	private JFrame guiFrame;
	private JTextField width;
	private JTextField height;
	private ListAction listAction;
	private FiguresList figuresList;
	private FiguresFactory figuresFactory;
	private AddErrorHandle error;

	public OkAction(JFrame addFrame, JTextField width, JTextField height, ListAction listAction, FiguresList figuresList, FiguresFactory figuresFactory, JFrame guiFrame) {
		this.addFrame = addFrame;
		this.width = width;
		this.height = height;
		this.listAction = listAction;
		this.figuresList = figuresList;
		this.figuresFactory = figuresFactory;
		this.guiFrame = guiFrame;
		error = new AddErrorHandle();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (!error.checkSelection(listAction.getSelection())) {
			error.ErrorFrame();
			return;
		}
		if ((error.checkTextField(width.getText()) || listAction.getSelection().isSymmetrical()) && error.checkTextField(height.getText())) {
			int figureHeight = parseInt(height.getText());
			int figureWidth = error.checkTextField(width.getText()) ? parseInt(width.getText()) : figureHeight;
			
			Figure f = figuresFactory.createFigure(listAction.getSelection(),figureWidth,figureHeight, guiFrame.getWidth(), guiFrame.getHeight());
			figuresList.addFigure(f);
			addFrame.dispose();
		} else {
			error.ErrorFrame();
			return;
		}
	}
	
}
