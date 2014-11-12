package model;

import java.util.Observable;


import expr.Environment;

public class Sheet extends Observable implements Environment{
	//TODO
	private SlotFactory slotFactory;
	private String currentSlot;
	private SlotList slotList;

	public Sheet(){
		
	}
	
	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setCurrent(String slot){
		currentSlot = slot;
	}

}
