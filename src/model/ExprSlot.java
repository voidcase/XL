package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot {
	Expr ex;
	
	public double getValue(Environment env){ //TODO Osäker här.
		return ex.value(env);
	}
}
