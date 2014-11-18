package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javax.swing.JFileChooser;

import model.Sheet;

class SaveMenuItem extends OpenMenuItem {
	
	Sheet shit;
	
    public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet s) {
        super(xl, statusLabel, "Save");
        shit = s;
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
    	try {
			FileWriter fw = new FileWriter(new File(path));
			Set<String> keys = shit.keySet();
					for(String key : keys);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}