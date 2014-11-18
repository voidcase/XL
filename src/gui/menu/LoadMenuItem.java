package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import model.Sheet;
import model.Slot;
import model.XLBufferedReader;
import model.XLException;

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
		super(xl, statusLabel, "Load");
		this.sheet = sheet;
	}

	protected void action(String path) throws FileNotFoundException {
		// TODO
		try {
			XLBufferedReader reader = new XLBufferedReader(path);
			HashMap<String, Slot> map = new HashMap();
			reader.load(map);
			sheet = new Sheet(map);	
		} catch (XLException e){
			throw new XLException(e.getMessage());
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}