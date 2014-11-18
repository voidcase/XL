package model;

import expr.Environment;

public interface Slot {
	public double value(Environment e);
	public String toString();
	public String display(Environment e);
}