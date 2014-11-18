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
		try {
			File target = new File(path);
			FileWriter fw = new FileWriter(target);
			Set<String> keys = blad.keySet();
			target.delete();
			for (String key : keys) {
				fw.write(key + "=" + blad.getSlotText(key) + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			throw new FileNotFoundException();
		}
//		File target = new File(path);
//		XLPrintStream stream = new XLPrintStream(path);
//		target.delete();
//		Set<String> keys = blad.keySet();
//		for (String key : keys) {
//			stream.
//		}
		
		
		
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}