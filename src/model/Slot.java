package model;

import expr.Environment;

public interface Slot {
	public double value(Environment e);
	public abstract String toString();
}