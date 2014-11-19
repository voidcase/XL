package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.awt.Color;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SheetPanel extends BorderPanel implements Observer {
    private SlotLabels slots;
    Controller controller;
    
    public SheetPanel(int rows, int columns, Controller controller) {
        add(WEST, new RowLabels(rows));
        slots = new SlotLabels(rows, columns, controller);
        add(CENTER, slots);
        this.controller = controller;
    }

    public List<Observer> getListObservers() {
        return slots.listObservers();
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		String coloredLabel = slots.coloredLabel();
		
		String current = controller.getCurrent();
		if(!(current.equals(coloredLabel))){
			slots.setBackgroundColor(Color.WHITE, coloredLabel);
			slots.setBackgroundColor(Color.YELLOW, current);
			coloredLabel = current;			
		}		
	}
}
