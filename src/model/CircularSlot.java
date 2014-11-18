package model;

import expr.Environment;

public class CircularSlot implements Slot {

	@Override
	public double value(Environment e) {
		throw new XLException("Circular reference!");
	}

	@Override
	public String toString(){
		return "CircularSlot";
	}

	public String display(Environment e) {
		return "";
	}
}
