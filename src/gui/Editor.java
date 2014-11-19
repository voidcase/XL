package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.XLException;

public class Editor extends JTextField implements Observer{
	
	private Controller ctrl;
	
	public Editor(Controller c) {
        setBackground(Color.WHITE);
        addActionListener(new EditorListener());
        ctrl = c;
    }
	
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(ctrl.currentString());
	}
	
	private class EditorListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
			ctrl.update(getText());
			} catch (XLException e){
				System.out.println("editor : " + e.getMessage());
				throw new XLException(e.getMessage());
			}
		}
		
	}
	
}