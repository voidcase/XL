package gui;

import java.util.Observable;

import model.Sheet;

public class Controller extends Observable {
    private Sheet sheet;
    private String current;

    public Controller(Sheet sheet) {
	this.sheet = sheet;
	current = "A1";
    }
    
    /**
     * Sets current slot to address
     */
    public void setCurrent(String address) {
	current = address;
	notifyObservers();
    }

    /**
     * Returns current slot
     */
    public String getCurrent() {
	return current;
    }

    public String currentString(String address) {
	return sheet.getString(address);
    }

    /**
     * Enter content into current slot
     */
    public void update(String content) {
	sheet.update(current, content);
	notifyObservers();
    }
}