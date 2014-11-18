package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer, MouseListener{
	private char col;
	private int row;
	private Sheet sheet;
	private Controller controller;
	
    public SlotLabel(char col, int row, Controller controller) {
        super("                    ", Color.WHITE, RIGHT);
       this.col = col; 
       this.row = row;
       this.controller = controller;
       addMouseListener(this);
       
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		sheet = (Sheet) arg0;
		String string = sheet.getSlotText("" + col + row);
		this.setText(string);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		controller.setCurrent("" + col + row);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}