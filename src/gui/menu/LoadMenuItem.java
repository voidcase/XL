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
import java.io.File;
//FIXME: loaded sheet not visible.
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
			//<DEBUG>
			for(String k : map.keySet()){
				System.out.print(k + " ");
			}
			System.out.println("");
			for(Slot i : map.values()){
				System.out.print(i.toString() + " ");
			}
			//</DEBUG>
			sheet = new Sheet(map);
			//sheet.update("A1", sheet.getSlotText("A1"));//TODO snygga till om möjligt.
		} catch (XLException e){
			throw new XLException(e.getMessage());
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}