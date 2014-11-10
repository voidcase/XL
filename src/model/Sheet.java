package model;

import java.util.Observable;


import expr.Environment;

public class Sheet extends Observable implements Environment{
	//TODO
	private SlotFactory slotFactory;
	private Slot current;

	public void update(){
		//TODO
	}

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
}
