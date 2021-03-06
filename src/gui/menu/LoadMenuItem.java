package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFileChooser;

import model.Sheet;
import model.Slot;
import model.XLBufferedReader;
import model.XLException;
import java.io.File;
class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
		super(xl, statusLabel, "Load");
		this.sheet = sheet;
	}

	protected void action(String path) throws FileNotFoundException {
		try {
			XLBufferedReader reader = new XLBufferedReader(path);
			HashMap<String, Slot> map = new HashMap<String, Slot>();
			reader.load(map);
			sheet.changeMap(map);	
		} catch (XLException e){
			throw new XLException(e.getMessage());
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}