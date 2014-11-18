package gui.menu;

import gui.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    
	private Controller ctrl;
	public ClearMenuItem(Controller c) {
        super("Clear");
        addActionListener(this);
        ctrl = c;
    }

    public void actionPerformed(ActionEvent e) {
    	ctrl.update("");
    }
}