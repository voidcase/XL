package gui;

import java.util.Observable;

import model.Sheet;
import model.XLException;

public class Controller extends Observable {
    private Sheet sheet;
    private String current;
    private String status;

    public Controller(Sheet sheet) {
    	this.sheet = sheet;
		current = "A1";
    }
    
    /**
     * Sets current slot to address
     */
    public void setCurrent(String address) {
    	current = address;
    	setChanged();
    	notifyObservers();
    }
    
    /**
     * Returns current slot address
     */
    public String getCurrent() {
    	return current;
    }

    /**
     * Returns a string representation of the content of
     * the address slot
     */
    public String currentString() {
    	return sheet.getSlotText(current);
    }
    

    /**
     * Enter content into current slot
     */
    public void update(String content) {	/*[NOT-AN-OBSERVER]*/
    	try {
    	sheet.update(current, content);
    	} catch (XLException e){
    		System.out.println("controller : " + e.getMessage());
    		status = e.getMessage();
    		setChanged();
    		this.notifyObservers(status);
    		throw new XLException(e.getMessage());
    	}
    	setChanged();
    	notifyObservers();
    }
}
