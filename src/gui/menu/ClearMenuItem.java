package gui.menu;

import gui.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    
	private Controller controller;
	
	public ClearMenuItem(Controller c) {
        super("Clear");
        addActionListener(this);
        controller = c;
    }

    public void actionPerformed(ActionEvent e) {
    	controller.update("");
    }
}