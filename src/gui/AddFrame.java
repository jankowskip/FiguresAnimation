package gui;

import gui.listeners.ListAction;
import gui.listeners.OkAction;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import model.FigureType;
import model.FiguresFactory;
import model.FiguresList;

public class AddFrame extends JFrame {
	private JPanel listPanel;
	private JPanel componentsPanel;
	private JLabel height;
	private JLabel width;
	private JTextField heightField;
	private JTextField widthField;
	private JButton accept;
	private JList<FigureType> jlist;
	private JScrollPane scroller;
	private ListAction listAction;

	public AddFrame(FiguresList figuresList, FiguresFactory figuresFactory, JFrame guiFrame) {
		super("Add Figure");
		listPanel = new JPanel();
		componentsPanel = new JPanel();
		height = new JLabel("Height");
		width = new JLabel("Width");
		heightField = new JTextField(4);
		widthField = new JTextField(4);
		accept = new JButton("Ok");
		jlist = new JList<FigureType>(figuresFactory.getTypeList().toArray(new FigureType[]{}));
		scroller = new JScrollPane();
		listAction = new ListAction(jlist, widthField);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addListSelectionListener(listAction);
		accept.addActionListener(new OkAction(this, widthField, heightField, listAction, figuresList, figuresFactory, guiFrame));
		componentsPanel.add(height);
		componentsPanel.add(heightField);
		componentsPanel.add(width);
		componentsPanel.add(widthField);
		componentsPanel.add(accept);
		listPanel.add(jlist);
		getContentPane().add(BorderLayout.CENTER, jlist);
		getContentPane().add(BorderLayout.EAST, componentsPanel);
		setSize(400, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
