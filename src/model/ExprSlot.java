package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot {
	Expr ex;

	public ExprSlot(Expr expr) {
		ex = expr;
	}

	public double value(Environment env) {
		return ex.value(env);
	}

	public String toString() {
		return ex.toString();
	}

}
