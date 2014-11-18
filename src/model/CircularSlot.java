package model;

import expr.Environment;

public class CircularSlot implements Slot {

	@Override
	public double value(Environment e) {
		// TODO Auto-generated method stub
		throw new XLException("Circular reference!");
	}
}