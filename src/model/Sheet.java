package model;

import java.util.Observable;


import expr.Environment;

public class Sheet extends Observable implements Environment{
	//TODO
	private SlotFactory slotFactory;
	private String currentSlot;
	private SlotList slotList;

	public Sheet(){
		slotFactory = new SlotFactory();
	}
	
	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCurrent() {
		return currentSlot;	
	}
	
	public void setCurrent(String address){
		currentSlot = address;
	}
	
	public void createSlot(String text){
		
	}
	
	public String getSlotText(String address){
		return slotList.get(address).toString();
	}
}
