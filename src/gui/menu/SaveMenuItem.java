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

	private Sheet blad;

	public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet s) {
		super(xl, statusLabel, "Save");
		blad = s;
	}

	protected void action(String path) throws FileNotFoundException {
		File target = new File(path);
		XLPrintStream stream = new XLPrintStream(path);
		target.delete();
		Set<String> keys = blad.keySet();
		stream.save(keys, blad);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}