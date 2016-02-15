package gui.listeners;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.FigureType;

public class ListAction implements ListSelectionListener {
	private JList<FigureType> jlist;
	private FigureType selection;
	private JTextField widthField;

	public ListAction(JList<FigureType> jlist, JTextField widthField) {
		this.jlist = jlist;
		this.widthField = widthField;

	}

	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			selection = (FigureType) jlist.getSelectedValue();
			if (selection.isSymmetrical()) {
				widthField.setEditable(false);
				widthField.setText("");
			} else {
				widthField.setEditable(true);
			}

		}

	}

	public FigureType getSelection() {
		return selection;
	}

}
