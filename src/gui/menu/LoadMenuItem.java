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

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
		super(xl, statusLabel, "Load");
		this.sheet = sheet;
	}

	protected void action(String path) throws FileNotFoundException {
		// TODO
		XLBufferedReader reader = new XLBufferedReader(path);

		HashMap<String, Slot> map = new HashMap();
		sheet = new Sheet(map);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}