package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLException;
//FIXME: Enter måste tryckas ner 2 ggr första gången.
public class Editor extends JTextField implements Observer {

	private Controller controller;

	public Editor(Controller c) {
		setBackground(Color.WHITE);
		addActionListener(new EditorListener());
		controller = c;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(controller.currentString());
	}

	private class EditorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				controller.update(getText());
			} catch (XLException e) {
			
			}
		}
	}
}