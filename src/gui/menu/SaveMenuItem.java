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
import model.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {
	private Sheet sheet;

	public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet s) {
		super(xl, statusLabel, "Save");
		sheet = s;
	}

	protected void action(String path) throws FileNotFoundException {
		XLPrintStream stream = new XLPrintStream(path + ".xl");
		Set<String> keys = sheet.keySet();
		stream.save(keys, sheet);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}