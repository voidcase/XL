package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends Slot {
	Expr ex;

	public ExprSlot(Expr expr) {
		ex = expr;
	}

	public double value(Environment env) { // TODO Osäker här.
		return ex.value(env);
	}

	public String toString() {
		return ex.toString();
	}

}
