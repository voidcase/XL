package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements ActionListener, Observer {
	private char col;
	private int row;
	private Sheet sheet;
	
    public SlotLabel(char col, int row) {
        super("                    ", Color.WHITE, RIGHT);
       this.col = col; 
       this.row = row;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		sheet = (Sheet) arg0;
		sheet.getSlotText("" + col + row);
		// TODO Auto-generated method stub
		
		
	}
}