package model;
import java.util.Observable;
import java.util.Observer;

import expr.Environment;

public abstract class Slot {
	//TODO
	public double value(Environment e){
		return 0;
	}
	
	public abstract String toString();
}
