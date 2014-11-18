package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.awt.Color;
import java.util.List;
import java.util.Observer;

public class SheetPanel extends BorderPanel {
    private SlotLabels slots;
    
    public SheetPanel(int rows, int columns, Controller controller) {
        add(WEST, new RowLabels(rows));
        slots = new SlotLabels(rows, columns, controller);
        add(CENTER, slots);
    }

    public List<Observer> getListObservers() {
        return slots.listObservers();
    }
    
    public void setBackgroundColor(Color color, String address) {
    	slots.setBackgroundColor(Color.YELLOW, address);
    }
}
