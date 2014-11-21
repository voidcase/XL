package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JMenuItem;
import model.Sheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	
	private Sheet sheet;
	
    public ClearAllMenuItem(Sheet s) {
        super("Clear all");
        addActionListener(this);
        sheet = s;
    }

    public void actionPerformed(ActionEvent e) {
    	Set<String> keys = sheet.keySet();
    	Iterator<String> it = keys.iterator();
    	while (it.hasNext()) {
    		it.next();
    		it.remove();
    	}
    	sheet.updateView();
    }
}