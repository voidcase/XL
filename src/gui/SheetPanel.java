package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class SheetPanel extends BorderPanel {
    private SlotLabels slots;
    
    public SheetPanel(int rows, int columns) {
        add(WEST, new RowLabels(rows));
        slots = new SlotLabels(rows, columns)
        add(CENTER, slots);
    }

    public List<Observer> listObservers() {
        return slots.listObservers();
    }
}
