package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.Sheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	
	Sheet shit;
	
    public ClearAllMenuItem(Sheet s) {
        super("Clear all");
        addActionListener(this);
        shit = s;
    }

    public void actionPerformed(ActionEvent e) {
    	//shit.removeAll();			--TODO väntar på att Love ska implementera i sheet. 
    }
}