package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.util.List;

public class SheetPanel extends BorderPanel {
    private SlotLabels slots;
    
    public SheetPanel(int rows, int columns, Controller controller) {
        add(WEST, new RowLabels(rows));
        slots = new SlotLabels(rows, columns, controller);
        add(CENTER, slots);
    }

    public List listObservers() {
        return slots.listObservers();
    }
}
