package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot {
	Expr ex;
	
	public double value(Environment env){ //TODO Osäker här.
		return ex.value(env);
	}
	
}
