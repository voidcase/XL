package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

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
    	Set<String> keys = shit.keySet();
    	for(String key : keys){
    		shit.remove(key);
    	}
    }
}